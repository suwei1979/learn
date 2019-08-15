/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.exception;

/**
 * @classname: UserNotExistException
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 6:42 PM
 * @modified
 **/
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String message) {
        super(message);
    }
}
