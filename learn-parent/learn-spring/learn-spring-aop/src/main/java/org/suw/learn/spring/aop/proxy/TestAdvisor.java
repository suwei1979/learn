/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.aop.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;

public class TestAdvisor implements Advisor {

	@Override
	public Advice getAdvice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPerInstance() {
		// TODO Auto-generated method stub
		return false;
	}

}
