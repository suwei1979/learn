/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.domain.model.BookingContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultBookingSequenceValidator implements ConstraintValidator<TestBookingSequence, BookingContext> {

    @Override
    public void initialize(TestBookingSequence constraintAnnotation) {
        log.info("簿记流程初始化");

    }

    @Override
    public boolean isValid(BookingContext value, ConstraintValidatorContext context) {
        log.info("执行簿记流程下的默认实体校验");
        return true;
    }

}
