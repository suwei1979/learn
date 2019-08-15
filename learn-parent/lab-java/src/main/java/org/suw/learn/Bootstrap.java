/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.suw.learn.*")
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    //    private static void doSomething(ApplicationContext context) {
    //        OrderService orderService = context.getBean(OrderService.class);
    //        String customerId = "CUS0001";
    //        Item item = context.getBean(Item.class);
    //        item.setName("ITEM0001");
    //        item.setZipCode("110000");
    //
    //        Order order = null;
    //        try {
    //            order = orderService.placeOrder(customerId, item, 3);
    //        } catch (ConstraintViolationException e) {
    //            Set<ConstraintViolation<?>> results = e.getConstraintViolations();
    //            for (ConstraintViolation<?> result : results) {
    //                //			    System.out.println("校验错误信息模板： " + result.getMessageTemplate());
    //                System.out.println(
    //                        "" + result.getLeafBean().getClass().getName() + "." + result.getPropertyPath() + ": " + result.getMessage());
    //                //				System.out.println(result.getConstraintDescriptor());
    //            }
    //
    //            //			System.out.println(results);
    //        }
    //        System.out.println("返回的订单信息： " + order);
    //    }
    //
    //    @Bean
    //    ValidatorFactory validatorFactory() {
    //        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
    //        return validator;
    //    }
    //
    //    @Bean
    //    ServiceLocator serviceFactory() {
    //        return new SpringServiceLocator();
    //    }
    //
    //    @Bean
    //    MethodValidationPostProcessor vethodValidationPostProcessor() {
    //        MethodValidationPostProcessor result = new MethodValidationPostProcessor();
    //        result.setValidatorFactory(validatorFactory());
    //        return result;
    //    }
    //
    //    @Bean
    //    EntityManager<Order> orderManager() {
    //        return new EntityManagerImpl<>(Order.class);
    //    }
}
