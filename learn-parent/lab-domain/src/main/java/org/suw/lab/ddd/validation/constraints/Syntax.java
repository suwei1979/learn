/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.ddd.validation.constraints;

import java.lang.annotation.Documented;

import javax.validation.Constraint;

import org.suw.lab.ddd.validation.validator.SyntaxValidator;

@Documented
@Constraint(validatedBy = {SyntaxValidator.class})
public @interface Syntax {
    String message() default "wrong detailed text format";

}
