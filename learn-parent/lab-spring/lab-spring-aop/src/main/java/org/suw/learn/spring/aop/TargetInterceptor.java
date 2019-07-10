/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TargetInterceptor implements MethodInterceptor {

    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);
        System.out.println(Math.round(random));
        System.out.println(Boolean.getBoolean(Math.round(random) + ""));
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        boolean invokeFlag = true;//(Math.round(Math.random()) - 1 >= 0);

        String className = invocation.getClass().getName();
        System.out.println(className.substring(className.lastIndexOf(".") + 1) + " will" + (invokeFlag ? "" : " not")
                + " proceed " + invocation.getMethod().getName());
        Object result = null;
        // System.out.println("provider proceed:" + invokeFlag);
        if (invokeFlag) {
            result = invocation.proceed();
        }
        return result;
    }
}
