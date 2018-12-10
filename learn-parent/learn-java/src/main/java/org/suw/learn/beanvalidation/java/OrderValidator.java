/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderValidator implements BusinessEntityValidator<Order, String> {

    @Override
    public void initialize(BusinessEntity constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(Order value, ConstraintValidatorContext context) {
        log.info("校验失败 - " +  value.toString());
        return false;
    }

}
