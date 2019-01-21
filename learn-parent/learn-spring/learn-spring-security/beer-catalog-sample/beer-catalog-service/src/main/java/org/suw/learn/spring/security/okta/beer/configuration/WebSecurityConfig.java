/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @classname: SecurityConfig
 * @author: suwei
 * @description:
 * @date: created in 2018/12/22 : 10:39 PM
 * @modified
 **/
@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        super.configure(http);
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").hasRole("USER")
                //                    .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("USER")
                .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/login").permitAll()
                .and().logout()
                    .permitAll();
        //                .and()
        //                .httpBasic();
    }

    //    @Override
    //    protected UserDetailsService userDetailsService() {
    //        UserDetailsManager manager = new InMemoryUserDetailsManager();
    //        UserDetails user = User.withUsername("admin").password("password").roles("ADMIN").build();
    //        manager.createUser(user);
    //        return manager;
    //    }

    //    @Override
    //    public void configure(WebSecurity web) throws Exception {
    //        super.configure(web);
    //    }

    @Bean
    PasswordEncoder defaultPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //        auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER");
    //    }
}
