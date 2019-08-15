/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.exceptions;

public class DuplicatedApplicationException extends RuntimeException {

    private static final long serialVersionUID = -8517660374260197759L;

    public DuplicatedApplicationException(String messageKey) {
        super(messageKey);
    }
}
