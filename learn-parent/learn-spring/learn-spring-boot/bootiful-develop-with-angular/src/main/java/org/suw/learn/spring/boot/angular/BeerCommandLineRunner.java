/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.boot.angular;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.boot.angular.model.Beer;
import org.suw.learn.spring.boot.angular.repository.BeerRepository;

/**
 * @classname: BeerCommandLineRunner
 * @author: suwei
 * @description:
 * @date: created in 2018/12/31 : 6:39 PM
 * @modified
 **/

@Component
public class BeerCommandLineRunner implements CommandLineRunner {
    private BeerRepository beerRepository;

    public BeerCommandLineRunner(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name -> beerRepository.save(new Beer(name)));
        beerRepository.findAll().forEach(System.out::println);
    }
}
