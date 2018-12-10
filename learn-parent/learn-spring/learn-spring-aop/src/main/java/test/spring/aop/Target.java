/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.aop;

public class Target implements ITarget {

	
	public void doSomething() {
		System.out.println("doSomething()");
	}

	public void doA() {
		System.out.println("doA()");
	}

	public void otherThing() {
		System.out.println("otherThing()");
	}
}
