/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validation.constraints;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.suw.learn.validation.validator.MasterDataEntityValidator;

/**
 * @author suwei
 */
@Constraint(validatedBy = {MasterDataEntityValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface MasterDataEntity {
    String message() default "{com.acme.constraint.MasterDataEntity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
