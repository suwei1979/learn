/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.suw.lab.spring.beans.generics.GenericService;
import org.suw.lab.spring.beans.model.Order;

/**
 * @author suwei
 */
@SpringBootApplication
public class LearnSpringBeansApplication {
    @Autowired
    GenericService<Order> orderService;

    /**
     *
     */
    public LearnSpringBeansApplication() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBeansApplication.class, args);
    }

    //    /*
    //     * (non-Javadoc)
    //     *
    //     * @see Application#run(org.springframework.context.ApplicationContext)
    //     */
    //    @Override
    //    public void run(ApplicationContext context) {
    //        // context.getb
    //        System.out.println(orderService.insert(null));
    //
    //    }

}
