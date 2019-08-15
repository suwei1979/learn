/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi;

public class MainProcessExecutionException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -624043542756431764L;

    public MainProcessExecutionException(String msg, Throwable cause) {
        super(msg);
    }

    public MainProcessExecutionException(String msg) {
        super(msg);
    }

}
