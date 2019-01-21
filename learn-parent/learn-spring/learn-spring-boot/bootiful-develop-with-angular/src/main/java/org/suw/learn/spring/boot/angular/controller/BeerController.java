/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.boot.angular.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suw.learn.spring.boot.angular.model.Beer;
import org.suw.learn.spring.boot.angular.repository.BeerRepository;

/**
 * @classname: BeerController
 * @author: suwei
 * @description:
 * @date: created in 2019/1/1 : 9:19 AM
 * @modified
 **/
@RestController
public class BeerController {
    @Autowired
    private BeerRepository beerRepository;

    @GetMapping("/good-beers")
    public Collection<Beer> goodBeer() {
        return beerRepository.findAll().stream().filter(this::isGreat).collect(Collectors.toList());

    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}
