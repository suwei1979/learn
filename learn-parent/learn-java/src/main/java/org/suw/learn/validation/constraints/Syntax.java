/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.validation.constraints;

import java.lang.annotation.Documented;

import javax.validation.Constraint;

import org.suw.learn.validation.validator.SyntaxValidator;

@Documented
@Constraint(validatedBy = {SyntaxValidator.class})
public @interface Syntax {
    String message() default "wrong detailed text format";

}
