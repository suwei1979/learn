package org.suw.learn.spring.aop.proxy;

import org.springframework.stereotype.Service;

@Service
public class ConcreteService implements ServiceInterface {

	@Override
	public void dosomething() {
		System.out.println(getClass().getName() + ": dosomething");

	}

}
