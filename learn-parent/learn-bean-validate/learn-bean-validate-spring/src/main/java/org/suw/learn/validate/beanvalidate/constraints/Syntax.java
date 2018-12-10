/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.validate.beanvalidate.constraints;

import java.lang.annotation.Documented;

import javax.validation.Constraint;

import org.suw.learn.validate.beanvalidate.constraintsvalidator.SyntaxValidator;

@Documented
@Constraint(validatedBy = { SyntaxValidator.class })
public @interface Syntax {
	String message() default "wrong detailed text format";
	

}
