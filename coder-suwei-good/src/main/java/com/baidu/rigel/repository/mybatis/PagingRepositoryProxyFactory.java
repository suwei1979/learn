/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.Assert;

import com.baidu.rigel.repository.PagingRepository;
import com.baidu.rigel.util.ReflectionUtils;

/**
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
     * 为所有使用了PagingRepository的对象，自动生成代理
     *
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object,
     *      java.lang.String)
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

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(sqlSessionFactory);

    }

}
