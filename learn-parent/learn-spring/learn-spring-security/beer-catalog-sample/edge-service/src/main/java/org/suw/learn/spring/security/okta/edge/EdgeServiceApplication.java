/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.suw.learn.spring.security.okta.edge.interceptor.UserFeignClientInterceptor;

import feign.RequestInterceptor;

/**
 * @classname: EdgeServiceApplication
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 3:23 PM
 * @modified
 **/
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
@SpringBootApplication
public class EdgeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdgeServiceApplication.class, args);
    }

//    @Bean
//    public RequestInterceptor getUserFeignClientInterceptor() {
//        return new UserFeignClientInterceptor();
//    }


}
