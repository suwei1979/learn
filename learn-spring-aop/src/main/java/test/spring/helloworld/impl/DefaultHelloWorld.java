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
