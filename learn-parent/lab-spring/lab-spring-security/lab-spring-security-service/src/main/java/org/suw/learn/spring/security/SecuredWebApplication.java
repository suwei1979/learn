/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @classname: SecuredWebApplication
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 12:34 PM
 * @modified
 **/
@SpringBootApplication
@ComponentScan(value = "org.suw.learn.spring.security")
public class SecuredWebApplication {

    public static void main(String... args) {
        SpringApplication.run(SecuredWebApplication.class, args);
    }


}
