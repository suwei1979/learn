/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.mdm.spi.spring;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.suw.learn.mdm.spi.ServiceLocator;
import org.suw.learn.mdm.utils.Assert;

/**
 * 服务提供者工程的Spring实现
 *
 * @author suwei
 */
public class SpringServiceLocator implements ServiceLocator, ApplicationContextAware {
    private ApplicationContext applicationContext;

    /**
     * @see org.suw.learn.mdm.spi.ServiceLocator#create(String, Class)
     */
    @Override
    public <S> S create(String providerName, Class<S> serviceInterface) {
        S result;
        try {
            result = applicationContext.getBean(providerName, serviceInterface);
        } catch (NoSuchBeanDefinitionException e) {
            // 当找不到Bean时，返回空
            result = null;
        }
        return result;
    }

    /**
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * @see org.suw.learn.mdm.spi.ServiceLocator#create(String, Class, Class...)
     */
    @Override
    public <S> S create(String providerName, Class<S> serviceInterface, Class<?>... parameterizedTypes) {
        S genericProvider = create(providerName, serviceInterface);
        // boolean isMatched = isCandidateMatch(genericProvider, parameterizedTypes);
        return (isCandidateMatch(genericProvider, serviceInterface, parameterizedTypes) ? genericProvider : null);
    }

    /**
     * 判断{@code genericProvider}类上所声明的泛型与{@code expectedGenericTypes}是否匹配<br>
     * 判断逻辑：遍历expectedGeneric{@code expectedGenericType}，根据每个类型的索引取出 <br>
     * 声明的泛型，检查其类型是否匹配
     *
     * @param genericProvider   容器中实现了{@code expectedInterface}的具体提供者
     * @param expectedInterface 待匹配的接口
     * @param expectedTypeArgs  待匹配的类型参数
     *
     * @return
     */
    private <S> boolean isCandidateMatch(S genericProvider, Class<S> expectedInterface, Class<?>... expectedTypeArgs) {
        Type[] declaredGenericTypes = genericProvider.getClass().getGenericInterfaces();
        boolean isMatched = false;
        for (Type declaredGenericType : declaredGenericTypes) {
            ParameterizedType parameterizedType = (ParameterizedType) declaredGenericType;
            if (parameterizedType.getRawType().equals(expectedInterface)) {
                Type[] actualArguments = parameterizedType.getActualTypeArguments();
                Assert.isTrue(actualArguments.length >= expectedTypeArgs.length, String
                        .format("传入参数中有%d个泛型类型，而类声明中只有%d个", expectedTypeArgs.length, declaredGenericTypes.length));
                for (int i = 0; i < expectedTypeArgs.length; i++) {
                    Type actualArg = actualArguments[i];
                    if (actualArg instanceof ParameterizedType) {
                        isMatched = expectedTypeArgs[i].equals(((ParameterizedType) actualArg).getRawType());
                    } else {
                        isMatched = expectedTypeArgs[i].equals(actualArg);
                    }
                    // 如发现一项不匹配则返回
                    if (!isMatched) {
                        return isMatched;
                    }
                }
            }
        }

        return isMatched;
    }

    /**
     * @see org.suw.learn.mdm.spi.ServiceLocator#create(java.lang.Class, java.lang.Class[])
     */
    @Override
    public <S> S create(Class<S> serviceInterface, Class<?>... parameterizedTypes) {
        Map<String, S> providers = applicationContext.getBeansOfType(serviceInterface);
        List<S> results = new ArrayList<S>();
        for (S provider : providers.values()) {
            if (isCandidateMatch(provider, serviceInterface, parameterizedTypes)) {
                results.add(provider);
            }
        }
        if (results.size() == 1) {
            return results.get(0);
        } else if (results.size() > 1) {
            throw new RuntimeException("Find two candidate provider of " + serviceInterface
                    + " which parameterizedTypes are " + parameterizedTypes);

        } else {
            return null;
        }
    }

}
