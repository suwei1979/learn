package org.suw.learn.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.suw.learn.spring.boot.Application;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.suw.learn.spring")
public class Bootstrap {
	
    
	public static void main(String[] args) {
	
        ApplicationContext context = new SpringApplicationBuilder().web(false).sources(Bootstrap.class).run(args);
        Application application = context.getBean(Application.class);
		application.run(context);
	}

}
