/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.ddd.validation.validator;

import java.util.regex.Matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.suw.lab.ddd.domain.service.ConstraintValidatorUsedService;
import org.suw.lab.ddd.validation.constraints.ZipCode;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Autowired
    private ConstraintValidatorUsedService constraintValidatorUsedService;
    private String regexp;
    private String message;

    @Override
    public void initialize(ZipCode constraintAnnotation) {
        //        System.out.println(constraintAnnotation.annotationType().getName() + " validation initialized!");
        regexp = ZipCode.class.getAnnotation(Pattern.class).regexp();
        message = constraintAnnotation.message();
        //       System.out.println("regexp is " + regexp);
        //       System.out.println("message is" + message);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //        System.out.println("-------------------------validating master data entity field - " + value + "");

        // context.disableDefaultConstraintViolation();
        // context.buildConstraintViolationWithTemplate("Increct
        // zipcode").addBeanNode().inIterable().atKey("home").addConstraintViolation();
        // System.out.println(context.getDefaultConstraintMessageTemplate());
        // context.disableDefaultConstraintViolation();
        // context.buildConstraintViolationWithTemplate("{my.custom.template}").
        // .addConstraintViolation();
        constraintValidatorUsedService.test();
        Matcher matcher = java.util.regex.Pattern.compile(regexp).matcher(new StringBuffer(value));
        //         System.out.println("-------------------------validating master data entity field - " + value +", isValid = " + matcher
        // .matches());
        // + context.getDefaultConstraintMessageTemplate() + " finished!");
        return true;
    }

}
