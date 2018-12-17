/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.exception;

/**
 * Created by zion on 6/3/15.
 */
public class UtilityException extends GenericRuntimeException {
    private static final long serialVersionUID = 3772434246138553540L;

    public UtilityException(String code, Object[] args, Throwable cause) {
        super(code, args, cause);
    }

    public UtilityException(String code) {
        super(code);
    }

    public UtilityException(String code, Throwable cause) {
        super(code, cause);
    }
}
