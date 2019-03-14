/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.edge.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suw.learn.spring.security.okta.edge.feign.BeerClient;
import org.suw.learn.spring.security.okta.edge.model.Beer;

/**
 * @classname: GoodBeerApiAdapterRestController
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 6:14 PM
 * @modified
 **/
@RestController
public class GoodBeerApiAdapterRestController {
    private static final Logger logger = LoggerFactory.getLogger(GoodBeerApiAdapterRestController.class);

    @Autowired
    private BeerClient beerClient;

    public GoodBeerApiAdapterRestController() {

    }

    public Collection<Beer> fallback() {
        logger.info("GoodBeerApiAdapterRestController.fallback");
        return new ArrayList<>();
    }

//    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping(value = "/good-beers", headers = "Accept=application/json")
    @CrossOrigin(origins = "*")
    public Collection<Beer> goodBeers() {
        logger.info("================entering good beers====================");
        Collection<Beer> allBeers = beerClient.readBeers();
        logger.info("allBeers = " + allBeers);
        Collection<Beer> result = allBeers.stream().filter(this::isGreat).collect(Collectors.toList());
        return result;
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}
