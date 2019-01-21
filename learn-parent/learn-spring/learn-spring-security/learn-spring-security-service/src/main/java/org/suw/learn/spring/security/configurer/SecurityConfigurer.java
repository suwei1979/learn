/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.suw.learn.spring.security.service.UserServiceImpl;

/**
 * @classname: SecurityConfig
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 11:20 AM
 * @modified
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

//    private static String REALM = "MY_TEST_REALM";

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService())
//                    .passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configuration(http);
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/home","/").permitAll()
                    .antMatchers("/users/**").hasRole("USER")
                    .antMatchers("/hello").hasRole("USER")
                    .antMatchers("/actuator/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/login").permitAll()
                .and().logout()
                    .permitAll();

    }

//    @Bean
//    public CustomAuthenticationEntryPoint getBasicAuthenticationEntryPoint() {
//        return new CustomAuthenticationEntryPoint();
//    }

//    /**
//     * To allow a pre flight [options] request from browser
//     * @param controller
//     * @throws Exception
//     */
//    @Override
//    public void configuration(WebSecurity controller) throws Exception {
////        super.configuration(configurer);
//        controller.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//    }


    @Override
    protected UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
