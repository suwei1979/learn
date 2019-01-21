/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.suw.learn.spring.beans.generics.GenericService;
import org.suw.learn.spring.beans.model.Order;

/**
 * @author suwei
 */
@SpringBootApplication
public class LearnSpringBeansApplication {
    @Autowired
    GenericService<Order> orderService;

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBeansApplication.class, args);
    }

}

