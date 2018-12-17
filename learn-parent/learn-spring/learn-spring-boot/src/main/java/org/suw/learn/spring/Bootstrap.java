/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:*/*.xml");
        context.start();
        System.out.println("application started");
        System.out.println(context.getBeanDefinitionCount());
        context.stop();
        context.close();

    }

}
