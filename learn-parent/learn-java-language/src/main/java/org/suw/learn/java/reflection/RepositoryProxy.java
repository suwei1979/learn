/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author suwei
 */
public class RepositoryProxy implements InvocationHandler {

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated provider stub
        System.out.println(proxy.getClass());
        System.out.println(method.getName());
        return null;
    }

}
