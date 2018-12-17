/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdkDynamicProxy implements InvocationHandler {
    public static Set<Class<?>> dedicatedInterfaces = new HashSet<Class<?>>();

    static {
        dedicatedInterfaces.add(ServiceInterface.class);
    }

    ;
    private Object concreteService;

    private JdkDynamicProxy(Object concreteService) {
        this.concreteService = concreteService;
    }

    public static Object proxy(Object concreteService) {
        List<Class<?>> proxyedInterfaceList = new ArrayList<Class<?>>();
        Class<?>[] implementedInterfaces = concreteService.getClass().getInterfaces();
        for (Class<?> implementedInterface : implementedInterfaces) {
            if (dedicatedInterfaces.contains(implementedInterface)) {

                proxyedInterfaceList.add(implementedInterface);
            }
        }
        Class<?>[] proxyedInterfaceArray = new Class<?>[] {};
        proxyedInterfaceArray = proxyedInterfaceList.toArray(proxyedInterfaceArray);
        return Proxy.newProxyInstance(JdkDynamicProxy.class.getClassLoader(), proxyedInterfaceArray, new JdkDynamicProxy(concreteService));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy: " + proxy.getClass().getName());
        System.out.println("concreteService: " + concreteService.getClass().getName());
        System.out.println("do before");
        Object result = method.invoke(concreteService, args);
        System.out.println("do after");
        return result;
    }

    //	public static Object proxy(Object concreteService) {
    //		ProxyFactoryBean proxyFactory = new ProxyFactoryBean();
    //		proxyFactory.setInterfaces(dedicatedInterfaces);
    //
    //	}
}
