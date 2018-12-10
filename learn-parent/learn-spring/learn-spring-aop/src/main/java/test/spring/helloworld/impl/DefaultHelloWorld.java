/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.helloworld.impl;

import test.spring.helloworld.IHelloWorld;

public class DefaultHelloWorld implements IHelloWorld {
	private String greeting;

	public void setGreeting(String helloStr) {
		this.greeting = helloStr;
	}

	public void sayGreeting() {
		System.out.println(greeting);
	}

}
