/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.Assert;

import com.baidu.rigel.repository.PagingRepository;
import com.baidu.rigel.util.ReflectionUtils;

/**
 * Paging Repository Proxy Factory<br>
 * Configure this object in the spring container will automatically detect all classes that use the PagingRepository,
 * and create the {@link PagingRepositoryProxy} for every Field which type is PagingRepository. That is, all classes
 * that use the PagingRepository do not need to create any implementation, and do not need to write any code for
 * implementation.
 * 
 * @author suwei
 *
 */
public class PagingRepositoryProxyFactory implements InitializingBean, BeanPostProcessor {
    private SqlSessionFactory sqlSessionFactory;

    /**
     * Set the SqlSessionFactory
     *
     * @param sqlSessionFactory the sqlSessionFactory to set
     */
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     *
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object,
     *      java.lang.String)
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 在初始化前不做任何动作
        return bean;
    }

    /**
     * For all the class that in the spring container which have declared {@code PagingRepository } as it's <br>
     * fields, auto detect the bind types of Entity(say the <E> in the {@code PagingRepository} interface, <br>
     * generate the {@link PagingRepositoryProxy} instance, and inject it as fied value.
     * 
     * @param bean the new bean instance.
     * @param beanName the name of the bean instance.
     * 
     * @return return the bean instance to use, the field of {@link PagingRepository} type has been wired to
     *         {@link PagingRepositoryProxy}
     * @throws BeansException in case of errors.
     * 
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<Field> declaredPagingRepositories = ReflectionUtils.getDeclaredFields(bean, PagingRepository.class);

        for (Field pagingRepositoryField : declaredPagingRepositories) {
            Class<?> entityType = ReflectionUtils.getBindingGenericType(pagingRepositoryField, 0);
            PagingRepositoryProxy proxy = new PagingRepositoryProxy(entityType, sqlSessionFactory);

            ReflectionUtils.setFieldValue(bean, pagingRepositoryField, Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(), new Class<?>[] { PagingRepository.class }, proxy));
        }

        return bean;
    }

    /**
     * Assert that the {@link SqlSession} can not be null.
     */
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(sqlSessionFactory);

    }

}
