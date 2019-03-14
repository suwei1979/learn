/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @classname: HomeController
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 4:10 PM
 * @modified
 **/
@Controller
public class HomeController {

    @GetMapping("/home")
    @SuppressWarnings("unchecked")
    public String howdy(Model model, Principal principal) {
        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        if (principal != null) {
            Map<String, Object> user = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
            model.addAttribute("user", user);
        }
        return "home";
    }
}
