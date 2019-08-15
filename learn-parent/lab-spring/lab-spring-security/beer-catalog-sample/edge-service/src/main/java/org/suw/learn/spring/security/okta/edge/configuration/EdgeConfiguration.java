/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.edge.configuration;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.suw.learn.spring.security.okta.edge.interceptor.UserFeignClientInterceptor;

import feign.RequestInterceptor;

/**
 * @classname: EdgeConfiguration
 * @author: suwei
 * @description:
 * @date: created in 2018/12/23 : 7:27 PM
 * @modified
 **/
@Configuration
public class EdgeConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(EdgeConfiguration.class);

    @Bean
    RequestInterceptor getUserFeignClientInterceptor() {
        logger.info("Get Feign Client Interceptor!");
        return new UserFeignClientInterceptor();
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
        logger.info("Simple CorsFilter");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
