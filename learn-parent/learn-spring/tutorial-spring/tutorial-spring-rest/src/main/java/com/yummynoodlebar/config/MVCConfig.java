/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.yummynoodlebar.rest.controller"})
public class MVCConfig {
}
