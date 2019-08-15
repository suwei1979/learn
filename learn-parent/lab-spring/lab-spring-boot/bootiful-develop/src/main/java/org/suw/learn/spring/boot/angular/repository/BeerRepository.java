/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.boot.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.suw.learn.spring.boot.angular.model.Beer;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long> {
}
