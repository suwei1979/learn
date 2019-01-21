/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.suw.learn.spring.security.okta.beer.model.Beer;
import org.suw.learn.spring.security.okta.beer.repository.BeerRepository;

/**
 * @classname: BeerController
 * @author: suwei
 * @description:
 * @date: created in 2018/12/26 : 9:02 PM
 * @modified
 **/
@RestController
public class BeerController {
    private static final Logger logger = LoggerFactory.getLogger(BeerController.class);
    @Autowired
    BeerRepository beerRepository;
//
    @RequestMapping(path = "/beers", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Beer> listAllBeers(@RequestHeader HttpHeaders headers) {
        logger.info("request headers are: " + headers.toSingleValueMap().toString());
        List<Beer> result = beerRepository.findAll();
        logger.info("find all beers, the results are: ");
        result.forEach(value -> logger.info(value.toString()));
        return result;
    }
}
