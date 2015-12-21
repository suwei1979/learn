/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validate.beanvalidate.constraints;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.suw.learn.validate.beanvalidate.constraintsvalidator.MasterDataEntityValidator;
import org.suw.learn.validate.beanvalidate.constraintsvalidator.OrderValidator;

/**
 * @author suwei
 *
 */
@Constraint(validatedBy = {MasterDataEntityValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface MasterDataEntity {
    String message() default "{com.acme.constraint.MasterDataEntity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
