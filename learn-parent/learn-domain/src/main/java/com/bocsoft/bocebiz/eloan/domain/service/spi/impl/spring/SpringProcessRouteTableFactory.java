/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bocsoft.bocebiz.eloan.domain.service.spi.ProcessRouteTable;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ProcessRouteTableFactory;

public class SpringProcessRouteTableFactory implements ProcessRouteTableFactory, ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public ProcessRouteTable getRouteTable(String routeTable) {
        return applicationContext.getBean(routeTable, ProcessRouteTable.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
