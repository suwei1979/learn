/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.validate.beanvalidate.constraintsvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.validate.beanvalidate.constraints.DateParametersConsistent;

public class DateParametersConsistentValidator implements ConstraintValidator<DateParametersConsistent, String> {

	@Override
	public void initialize(DateParametersConsistent constraintAnnotation) {
		// TODO Auto-generated provider stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated provider stub
		return false;
	}

}
