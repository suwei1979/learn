/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.aop;

import java.lang.reflect.Method;

public class ThankYouAdvice implements org.springframework.aop.AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("thank you, after returnning advice,come again!");
	}

}
