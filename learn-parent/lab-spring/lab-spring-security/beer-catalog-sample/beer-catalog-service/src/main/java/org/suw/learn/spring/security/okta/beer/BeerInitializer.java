/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.security.okta.beer.model.Beer;
import org.suw.learn.spring.security.okta.beer.repository.BeerRepository;

/**
 * @classname: BeerInitializer
 * @author: suwei
 * @description:
 * @date: created in 2018/12/22 : 7:06 PM
 * @modified
 **/
@Component
class BeerInitializer implements CommandLineRunner {

    private final BeerRepository beerRepository;
    

    public BeerInitializer(@Autowired BeerRepository beerRepository, @Autowired UserDetailsService userDetailsService) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===============Initialize beers================");
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR")
                .forEach(beer -> beerRepository.save(new Beer(beer)));
        beerRepository.findAll().forEach(System.out::println);

    }
}