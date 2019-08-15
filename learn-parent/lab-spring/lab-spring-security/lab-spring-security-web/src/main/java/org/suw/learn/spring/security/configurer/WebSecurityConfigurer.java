/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.configurer;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @classname: WebSecurityConfigurer
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 12:21 PM
 * @modified
 **/
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
