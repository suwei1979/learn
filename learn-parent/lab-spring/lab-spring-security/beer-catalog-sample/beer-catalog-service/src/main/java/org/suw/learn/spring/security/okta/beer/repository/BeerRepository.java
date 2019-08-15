/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.suw.learn.spring.security.okta.beer.model.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
}
