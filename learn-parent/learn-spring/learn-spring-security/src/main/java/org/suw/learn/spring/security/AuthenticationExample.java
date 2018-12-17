/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @classname: AuthenticationExample
 * @author: suwei
 * @description:
 * @date: created in 2018/12/14 : 6:49 PM
 * @modified
 **/
public class AuthenticationExample {
    private static AuthenticationManager authenticationManager = new SampleAuthenticationManager();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please enter your username:");
            String name = in.readLine();
            System.out.println("Please enter you password:");
            String password = in.readLine();

            try {
                Authentication request = new UsernamePasswordAuthenticationToken(name, password);
                System.out.println("Before: " + request.toString());
                Authentication result = authenticationManager.authenticate(request);
                System.out.println("After: " + result.toString());
                SecurityContextHolder.getContext().setAuthentication(result);
                break;
            } catch (BadCredentialsException sex) {
                System.out.println("Authentication Failed: " + sex.getMessage());
            }
        }

        System.out.println("Successfully authenticated. Security context contains: " +
                SecurityContextHolder.getContext().getAuthentication());
    }
}
