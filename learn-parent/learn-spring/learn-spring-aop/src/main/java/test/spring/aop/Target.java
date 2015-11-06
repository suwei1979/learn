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
