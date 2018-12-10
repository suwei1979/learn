/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<Status, String> {
    private final String[] ALL_STATUS = { "created", "paid", "shipped", "closed" };

    public void initialize(Status status) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
       
        if (Arrays.asList(ALL_STATUS).contains(value))
            return true;
        return false;
    }
}