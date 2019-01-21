/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.edge.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

/**
 * @classname: ResourceServerConfig
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 3:34 PM
 * @modified
 **/

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
                .authorizeRequests()
                .antMatchers("/**")
                .authenticated();
    }
}
