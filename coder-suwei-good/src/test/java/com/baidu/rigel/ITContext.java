/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import lombok.extern.slf4j.Slf4j;


/**
 * 组装测试上下文
 * @author suwei
 *
 */
@Slf4j
public class ITContext implements BeanFactoryAware {
    BeanFactory beanFactory;
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;

    }
    
    @Test
    public void testUTContext() {
        log.info("test ut context");
        assertNotNull(beanFactory);
        assertNotNull(beanFactory.getBean(DataSource.class));
    }

}
