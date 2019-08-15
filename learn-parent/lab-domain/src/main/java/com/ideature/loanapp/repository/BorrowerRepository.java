/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.ideature.loanapp.repository;

import java.util.Collection;

import com.ideature.loanapp.domain.Borrower;

public interface BorrowerRepository {

    Borrower load(long borrowerId) throws RepositoryException;

    Collection<Borrower> getBorrowers() throws RepositoryException;

    void add(Borrower borrower) throws RepositoryException;

    void update(Borrower borrower) throws RepositoryException;

    void delete(long borrowerId) throws RepositoryException;

}
