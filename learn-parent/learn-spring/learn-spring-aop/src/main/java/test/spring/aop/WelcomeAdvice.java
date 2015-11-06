package test.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class WelcomeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Hello, welcome before advice");
	}

}
