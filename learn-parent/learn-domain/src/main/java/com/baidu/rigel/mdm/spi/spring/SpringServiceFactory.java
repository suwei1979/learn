/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.baidu.rigel.mdm.spi.spring;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.baidu.rigel.mdm.spi.ServiceFactory;
import com.baidu.rigel.mdm.utils.Assert;

/**
 * 服务提供者工程的Spring实现
 *
 * @author suwei
 */
public class SpringServiceFactory implements ServiceFactory, ApplicationContextAware {
    private ApplicationContext applicationContext;

    /**
     * @see com.baidu.rigel.mdm.spi.ServiceFactory#create(String, Class)
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
     * @see com.baidu.rigel.mdm.spi.ServiceFactory#create(String, Class, Class...)
     */
    @Override
    public <S> S create(String providerName, Class<S> serviceInterface, Class<?>... parameterizedTypes) {
        S genericProvider = create(providerName, serviceInterface);
        // boolean isMatched = isCandidateMatch(genericProvider, parameterizedTypes);
        return (isCandidateMatch(genericProvider, parameterizedTypes) ? genericProvider : null);
    }

    /**
     * 判断{@code genericProvider}类上所声明的泛型与{@code expectedGenericTypes}是否匹配<br>
     * 判断逻辑：遍历expectedGeneric{@code expectedGenericType}，根据每个类型的索引取出 <br>
     * 声明的泛型，检查其类型是否匹配
     *
     * @param genericProvider
     * @param expectedGenericTypes
     *
     * @return
     */
    private <S> boolean isCandidateMatch(S genericProvider, Class<?>... expectedGenericTypes) {
        Type[] declaredGenericTypes = genericProvider.getClass().getGenericInterfaces();
        Assert.isTrue(declaredGenericTypes.length >= expectedGenericTypes.length,
                String.format("传入参数中有%d个泛型类型，而类声明中只有%d个", expectedGenericTypes.length, declaredGenericTypes.length));
        boolean isMatched = false;
        for (int i = 0; i < expectedGenericTypes.length; i++) {
            Class<?> expectedGenericType = expectedGenericTypes[i];
            Type declaredGenericType = declaredGenericTypes[i];
            if (declaredGenericType instanceof ParameterizedType) {
                isMatched = expectedGenericType.equals(((ParameterizedType) declaredGenericType).getRawType());
            } else {
                isMatched = expectedGenericType.equals(declaredGenericType);
            }
            if (!isMatched) {
                break;
            }
        }
        return isMatched;
    }

    /**
     * @see com.baidu.rigel.mdm.spi.ServiceFactory#create(java.lang.Class, java.lang.Class[])
     */
    @Override
    public <S> S create(Class<S> serviceInterface, Class<?>... parameterizedTypes) {
        Map<String, S> genericProviders = applicationContext.getBeansOfType(serviceInterface);
        List<S> results = new ArrayList<S>();
        for (S genericProvider : genericProviders.values()) {
            if (isCandidateMatch(genericProvider, parameterizedTypes)) {
                results.add(genericProvider);
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
