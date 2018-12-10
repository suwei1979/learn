/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.suw.learn.spring.Bootstrap;
import org.suw.learn.spring.beans.generics.GenericService;
import org.suw.learn.spring.beans.model.Order;
import org.suw.learn.spring.boot.Application;

/**
 * @author suwei
 *
 */
public class LearnSpringBeansApplication implements Application {
    @Autowired
    GenericService<Order> orderService;

    /**
     * 
     */
    public LearnSpringBeansApplication() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.suw.learn.spring.boot.Application#run(org.springframework.context.ApplicationContext)
     */
    @Override
    public void run(ApplicationContext context) {
        // context.getb
        System.out.println(orderService.insert(null));

    }

    public static void main(String[] args) {
        Bootstrap.main(args);
    }

}
