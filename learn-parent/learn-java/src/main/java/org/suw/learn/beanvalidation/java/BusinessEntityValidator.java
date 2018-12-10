/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import javax.validation.ConstraintValidator;

public interface BusinessEntityValidator<E, ID> extends ConstraintValidator<BusinessEntity, E>{
//    @Override
//    public void initialize(BusinessEntity constraintAnnotation) {
//        
//    }
//
//    @Override
//    public boolean isValid(E value, ConstraintValidatorContext context) {
//        return false;
//    }

//    @Override
//    public void initialize(BusinessEntity constraintAnnotation) {
//       log.info("intializing " + constraintAnnotation + " validator");
//    }
//
//    @Override
//    public boolean isValid(BookingContext value, ConstraintValidatorContext context) {
//        context.disableDefaultConstraintViolation();
//        context.buildConstraintViolationWithTemplate("没有尼玛的业务实体啊！").addConstraintViolation();
//        log.info(value +" is invalid!");
//        return false;
//    }

}
