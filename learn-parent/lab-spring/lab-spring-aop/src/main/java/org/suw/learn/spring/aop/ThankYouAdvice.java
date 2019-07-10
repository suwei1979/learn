/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.aop;

import java.lang.reflect.Method;

public class ThankYouAdvice implements org.springframework.aop.AfterReturningAdvice {

    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
        System.out.println("thank you, after returnning advice,come again!");
    }

}
