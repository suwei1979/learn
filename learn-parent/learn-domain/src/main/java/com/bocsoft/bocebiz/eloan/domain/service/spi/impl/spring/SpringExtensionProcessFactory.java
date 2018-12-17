/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl.spring;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.DefaultExtensionProcess;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ExtensionProcess;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ExtensionProcessFactory;

public class SpringExtensionProcessFactory implements ExtensionProcessFactory, ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Autowired(required = true)
    private Executor executor;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     *
     */
    @Override
    public ExtensionProcess load(String processName) {
        return new DefaultExtensionProcess(applicationContext.getBean(processName), executor);
    }

    public void setThreadPool(Executor executor) {
        this.executor = executor;
    }

}