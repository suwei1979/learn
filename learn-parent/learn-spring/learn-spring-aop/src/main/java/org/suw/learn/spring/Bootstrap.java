package org.suw.learn.spring;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suw.learn.spring.aop.proxy.ServiceInterface;

public class Bootstrap {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:*/*.xml");
		context.start();
		System.out.println("application started");
		System.out.println(context.getBeanDefinitionCount());
		doSomething(context);
		context.stop();
		context.close();
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		System.out.println(validatorFactory);
//		System.out.println(validatorFactory.getValidator());
	}

	private static void doSomething(ApplicationContext context) {
		Collection<ServiceInterface> serviceInterfaces = context.getBeansOfType(ServiceInterface.class).values();
		System.out.println("nums of implementation of serviceinterface: " + serviceInterfaces.size());
		
		for (ServiceInterface service: serviceInterfaces) {
			service.dosomething();
		}
	}

}
