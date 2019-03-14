/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.edge.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @classname: UserFeignClientInterceptor
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 4:52 PM
 * @modified
 **/
@Component
public class UserFeignClientInterceptor implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UserFeignClientInterceptor.class);
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        logger.info("=======entering the apply method!========");
        logger.info(template.url());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        logger.info("====================" + authentication);

        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails ) {
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, details.getTokenValue()));
            logger.info("template headers: " + template.headers().toString());
        }

    }
}
