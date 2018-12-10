/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidatorFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.suw.learn.domain.model.Item;
import org.suw.learn.domain.model.Order;
import org.suw.learn.domain.order.service.OrderService;
import org.suw.learn.domain.service.EntityManager;
import org.suw.learn.domain.service.impl.EntityManagerImpl;
import org.suw.learn.mdm.spi.ServiceLocator;
import org.suw.learn.mdm.spi.spring.SpringServiceLocator;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.suw.learn.*")
public class Bootstrap {
	
    
	public static void main(String[] args) {
	
        ApplicationContext context = new SpringApplicationBuilder().web(false).sources(Bootstrap.class).run(args);
        
		System.out.println("application started");
		doSomething(context);
		
	}

	private static void doSomething(ApplicationContext context) {
		OrderService orderService = context.getBean(OrderService.class);
		String customerId = "CUS0001";
		Item item = context.getBean(Item.class);
		item.setName("ITEM0001");
		item.setZipCode("110000");

		
		Order order = null;
		try {
			order = orderService.placeOrder(customerId, item, 3);
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			Set<ConstraintViolation<?>> results = e.getConstraintViolations();
			for (ConstraintViolation<?> result : results) {
//			    System.out.println("校验错误信息模板： " + result.getMessageTemplate());
				System.out.println("" + result.getLeafBean().getClass().getName() + "." + result.getPropertyPath() + ": " + result.getMessage());
//				System.out.println(result.getConstraintDescriptor());
			}
			
//			System.out.println(results);
		}
		System.out.println("返回的订单信息： " + order);
	}
	@Bean
	ValidatorFactory validatorFactory() {
	    LocalValidatorFactoryBean validator =  new LocalValidatorFactoryBean();
	    return validator;
	}
	
	@Bean
	ServiceLocator serviceFactory() {
	    return new SpringServiceLocator();
	}
	
	@Bean
	MethodValidationPostProcessor vethodValidationPostProcessor() {
	    MethodValidationPostProcessor result = new MethodValidationPostProcessor();
	    result.setValidatorFactory(validatorFactory());
	    return result;
	}
	
	@Bean 
	EntityManager<Order> orderManager() {
	    return new EntityManagerImpl<>(Order.class);
	}
}
