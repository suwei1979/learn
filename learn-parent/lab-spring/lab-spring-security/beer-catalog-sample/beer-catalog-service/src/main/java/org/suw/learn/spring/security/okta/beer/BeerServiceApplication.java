/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @classname: BeerServiceApplication
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 6:01 PM
 * @modified
 **/
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
public class BeerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeerServiceApplication.class, args);
    }



}


