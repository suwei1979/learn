/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.validation.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.lab.ddd.validation.constraints.Status;

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