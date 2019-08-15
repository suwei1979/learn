/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.ddd.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.lab.ddd.validation.constraints.OrderNumber;

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
