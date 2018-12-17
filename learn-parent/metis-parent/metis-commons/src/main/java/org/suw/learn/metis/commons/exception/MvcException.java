/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.exception;

/**
 * Created by zion on 6/3/15.
 */
public class MvcException extends GenericRuntimeException {
    private static final long serialVersionUID = 563892964301657108L;

    public MvcException(String code, Object[] args, Throwable cause) {
        super(code, args, cause);
    }

    public MvcException(String code) {
        super(code);
    }

    public MvcException(String code, Throwable cause) {
        super(code, cause);
    }
}
