/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.ideature.loanapp.repository;

import java.util.Collection;

import com.ideature.loanapp.domain.ProductRate;

public interface ProductRateRepository {

    ProductRate load(long productRateId) throws RepositoryException;

    Collection<ProductRate> findAll() throws RepositoryException;

    void add(ProductRate productRate) throws RepositoryException;

    void update(ProductRate productRate) throws RepositoryException;

    void delete(long productRateId) throws RepositoryException;

}
