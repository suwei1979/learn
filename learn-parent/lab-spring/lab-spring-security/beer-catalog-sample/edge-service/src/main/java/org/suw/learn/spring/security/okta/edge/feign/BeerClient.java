/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.edge.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suw.learn.spring.security.okta.edge.model.Beer;

@FeignClient("beer-catalog-service")
public interface BeerClient {

    @RequestMapping(value = "/beers",method = RequestMethod.GET, consumes = "application/json")
    List<Beer> readBeers();
}
