/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.exceptions;

public class UnexistsCustomerException extends RuntimeException {

    private static final long serialVersionUID = 1891045701389817024L;

    public UnexistsCustomerException(String messageKey) {
        super(messageKey);
    }
}
