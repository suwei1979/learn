/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.GeneralProcessConfiguration;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.DefaultProcessProxy;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ExtensionProcessFactory;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ProcessRouteTableFactory;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Slf4j
public class ExtensionProcessAssembler implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object result = bean;
        if (bean.getClass().isAnnotationPresent(GeneralProcessConfiguration.class)) {
            log.info("Attaching ProcessAgent to main process named {}.", beanName);
            result = DefaultProcessProxy.proxy(bean, routeTableFactory(), extensionProcessFactory());
        }
        return result;
    }

    @Bean
    public ProcessRouteTableFactory routeTableFactory() {
        return new SpringProcessRouteTableFactory();
    }

    @Bean
    public ExtensionProcessFactory extensionProcessFactory() {
        return new SpringExtensionProcessFactory();
    }

    @Bean
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setAllowCoreThreadTimeOut(false);
        taskExecutor.setQueueCapacity(10);
        return taskExecutor;
    }
}
