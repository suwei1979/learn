/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.validate.beanvalidate.constraintsvalidator;

import java.text.Format;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.validate.beanvalidate.constraints.Syntax;

public class SyntaxValidator implements ConstraintValidator<Syntax, String> {
	private Set<Format> allowedFormats;
	@Override
	public void initialize(Syntax constraintAnnotation) {
//		allowedFormats = new HashSet<Format>(Arrays.asList())
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated provider stub
		return false;
	}

}
