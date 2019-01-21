/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.suw.learn.spring.beans.generics.GenericService;
import org.suw.learn.spring.beans.generics.GenericServiceImpl;
import org.suw.learn.spring.beans.generics.GenericServiceInjector;
import org.suw.learn.spring.beans.model.Item;
import org.suw.learn.spring.beans.model.ItemFactory;
import org.suw.learn.spring.beans.model.Order;
import org.suw.learn.spring.beans.model.OrderFactory;

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

    @Bean
    GenericServiceInjector genericServiceInjector() {
        return new GenericServiceInjector();
    }
}
