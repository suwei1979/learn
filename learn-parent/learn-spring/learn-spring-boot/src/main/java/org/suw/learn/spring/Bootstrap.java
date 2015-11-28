package org.suw.learn.spring;

import java.util.Set;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.suw.learn.spring.boot.Application;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.suw.learn")
public class Bootstrap {
	
    
	public static void main(String[] args) {
	
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(Bootstrap.class, args);
        ApplicationContext context = new SpringApplicationBuilder().web(false).sources(Bootstrap.class).run(args);
        Application application = context.getBean(Application.class);
		application.run(context);
		
		
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		System.out.println(validatorFactory);
//		System.out.println(validatorFactory.getValidator());
	}

}
