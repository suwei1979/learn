package org.suw.learn.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringCoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml", "dao.xml");

    }

}
