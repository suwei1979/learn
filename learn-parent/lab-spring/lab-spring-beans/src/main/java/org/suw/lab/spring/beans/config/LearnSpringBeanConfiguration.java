/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD:learn-parent/lab-spring/lab-spring-beans/src/main/java/org/suw/lab/spring/beans/config/LearnSpringBeanConfiguration.java
import org.suw.lab.spring.beans.generics.GenericService;
import org.suw.lab.spring.beans.generics.GenericServiceImpl;
import org.suw.lab.spring.beans.generics.GenericServiceInjector;
import org.suw.lab.spring.beans.model.Item;
import org.suw.lab.spring.beans.model.ItemFactory;
import org.suw.lab.spring.beans.model.Order;
import org.suw.lab.spring.beans.model.OrderFactory;
=======
import org.suw.learn.spring.beans.generics.GenericService;
import org.suw.learn.spring.beans.generics.GenericServiceImpl;
import org.suw.learn.spring.beans.generics.GenericServiceInjector;
import org.suw.learn.spring.beans.model.Item;
import org.suw.learn.spring.beans.model.ItemFactory;
import org.suw.learn.spring.beans.model.Order;
import org.suw.learn.spring.beans.model.OrderFactory;
>>>>>>> master:learn-parent/learn-spring/learn-spring-beans/src/main/java/org/suw/learn/spring/beans/config/LearnSpringBeanConfiguration.java

/**
 * @author suwei
 */
@Configuration
public class LearnSpringBeanConfiguration {
    @Bean
    public ItemFactory itemFactory() {
        return new ItemFactory();
    }

    @Bean
    public OrderFactory orderFactory() {
        return new OrderFactory();
    }

    @Bean
    public GenericService<Order> orderService() {
        return new GenericServiceImpl<>(Order.class);
    }

    @Bean
    public GenericService<Item> itemService() {
        return new GenericServiceImpl<>(Item.class);
    }

<<<<<<< HEAD:learn-parent/lab-spring/lab-spring-beans/src/main/java/org/suw/lab/spring/beans/config/LearnSpringBeanConfiguration.java
    //    @Bean
    //    public Application application() {
    //        return new LearnSpringBeansApplication();
    //    }

=======
>>>>>>> master:learn-parent/learn-spring/learn-spring-beans/src/main/java/org/suw/learn/spring/beans/config/LearnSpringBeanConfiguration.java
    @Bean
    GenericServiceInjector genericServiceInjector() {
        return new GenericServiceInjector();
    }
}
