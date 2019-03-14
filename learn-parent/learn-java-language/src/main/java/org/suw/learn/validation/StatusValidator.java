/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.validation;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<Status, String> {
    private final String[] ALL_STATUS = {"created", "paid", "shipped", "closed"};

    public void initialize(Status status) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (Arrays.asList(ALL_STATUS).contains(value)) {
            return true;
        }
        return false;
    }
}