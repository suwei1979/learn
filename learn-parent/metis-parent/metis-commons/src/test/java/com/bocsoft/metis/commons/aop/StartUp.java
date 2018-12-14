package com.bocsoft.metis.commons.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suw.learn.metis.commons.utils.LoggingUtils;

import java.io.IOException;

/**
 * Created by zion on 12/5/14.
 */
public class StartUp {
    public static void main(String[] args) throws IOException {
        LoggingUtils.initSystemLoggingArgs("metis", "provider", "001");
        @SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:exception.xml");
        context.start();
        System.in.read();
    }
}
