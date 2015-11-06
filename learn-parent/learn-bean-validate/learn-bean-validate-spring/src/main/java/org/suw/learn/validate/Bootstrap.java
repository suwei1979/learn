package org.suw.learn.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suw.learn.domain.model.Item;
import org.suw.learn.domain.model.Order;
import org.suw.learn.domain.service.OrderService;

public class Bootstrap {
	
	public static void main(String[] args) {
	
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(Bootstrap.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring*.xml");
		context.start();
		System.out.println("application started");
		doSomething(context);
		context.stop();
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		System.out.println(validatorFactory);
//		System.out.println(validatorFactory.getValidator());
	}

	private static void doSomething(ApplicationContext context) {
		OrderService orderService = context.getBean(OrderService.class);
		String customerId = "CUS0001";
		Item item = context.getBean(Item.class);
		item.setName("ITEM0001");
		item.setZipCode("abc");

		
		Order order = null;
		try {
			order = orderService.placeOrder(customerId, item, 0);
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			Set<ConstraintViolation<?>> results = e.getConstraintViolations();
			for (ConstraintViolation<?> result : results) {
				System.out.println( result.getPropertyPath().toString() +  result.getMessage());
			}
			
//			System.out.println(results);
		}
		System.out.println(order);
	}

}
