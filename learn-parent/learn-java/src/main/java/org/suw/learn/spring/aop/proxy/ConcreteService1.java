/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.aop.proxy;

import org.springframework.stereotype.Service;

@Service
public class ConcreteService1 implements ServiceInterface {

	@Override
	public void dosomething() {
		System.out.println(getClass().getName() + ": dosomething");

	}

}
