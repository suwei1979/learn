/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.validation.constraints.OrderNumber;

public class OrderNumberValidator implements ConstraintValidator<OrderNumber, String> {

    @Override
    public void initialize(OrderNumber constraintAnnotation) {
        // TODO Auto-generated provider stub

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated provider stub
        return false;
    }

}
