/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.security.okta.beer.model.Beer;
import org.suw.learn.spring.security.okta.beer.repository.BeerRepository;

import com.netflix.discovery.converters.Auto;

/**
 * @classname: BeerServiceApplication
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 6:01 PM
 * @modified
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class BeerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeerServiceApplication.class, args);
    }



}


