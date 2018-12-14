/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DefaultProcessProxy implements InvocationHandler {
    private ProcessAgent interceptor;

    private DefaultProcessProxy(Object concreteService, ProcessRouteTableFactory routeTableFactory,
                                ExtensionProcessFactory extensionFactory) {
        this.interceptor = new DefaultProcessAgent(concreteService, routeTableFactory, extensionFactory);

    }

    public static Object proxy(Object concreteService, ProcessRouteTableFactory routeTableFactory,
                               ExtensionProcessFactory extensionFactory) {
        ClassLoader classLoader = concreteService.getClass().getClassLoader();
        DefaultProcessProxy invocationHandler = new DefaultProcessProxy(concreteService, routeTableFactory, extensionFactory);
        return Proxy.newProxyInstance(classLoader, invocationHandler.getProxyedInterfaces(), invocationHandler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = interceptor.process(method, args);
        return result;
    }

    public Class<?>[] getProxyedInterfaces() {
        return interceptor.getProxyedInterfaces();
    }
}