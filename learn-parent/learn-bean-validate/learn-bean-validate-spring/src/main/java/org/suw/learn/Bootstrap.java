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
import org.suw.learn.domain.service.OrderService;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.suw.learn.*")
public class Bootstrap {
	
    
	public static void main(String[] args) {
	
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(Bootstrap.class, args);
        ApplicationContext context = new SpringApplicationBuilder().web(false).sources(Bootstrap.class).run(args);
        
		System.out.println("application started");
		doSomething(context);
		
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		System.out.println(validatorFactory);
//		System.out.println(validatorFactory.getValidator());
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
			orderService.insert(order);
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
	@Bean
	ValidatorFactory validatorFactory() {
	    LocalValidatorFactoryBean validator =  new LocalValidatorFactoryBean();
	    return validator;
	}
	
	@Bean
	MethodValidationPostProcessor vethodValidationPostProcessor() {
	    MethodValidationPostProcessor result = new MethodValidationPostProcessor();
	    result.setValidatorFactory(validatorFactory());
	    return result;
	}
}
