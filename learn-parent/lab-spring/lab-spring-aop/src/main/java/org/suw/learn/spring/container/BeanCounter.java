/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.container;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanCounter implements BeanFactoryPostProcessor {
    private Log LOGGER = LogFactory.getLog(BeanCounter.class);

    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        LOGGER.info(factory.getBeanDefinitionCount());
    }

}
