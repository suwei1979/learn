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
 * The context for integration. the test cases for integration should extend this class.
 * 
 * @author suwei
 *
 */
@Slf4j
public class ITContext implements BeanFactoryAware {
    /**
     * the spring bean factory.
     */
    BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * Assert the main object for integration context
     */
    @Test
    public void testUTContext() {
        log.info("test ut context");
        assertNotNull(beanFactory);
        assertNotNull(beanFactory.getBean(DataSource.class));
    }

}
