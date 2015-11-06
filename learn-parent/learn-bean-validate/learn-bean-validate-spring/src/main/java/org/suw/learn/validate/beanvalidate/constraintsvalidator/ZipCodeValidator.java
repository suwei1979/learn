package org.suw.learn.validate.beanvalidate.constraintsvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.validate.beanvalidate.constraints.ZipCode;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Override
	public void initialize(ZipCode constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// context.disableDefaultConstraintViolation();
		// context.buildConstraintViolationWithTemplate("Increct zipcode").addBeanNode().inIterable().atKey("home").addConstraintViolation();
		// System.out.println(context.getDefaultConstraintMessageTemplate());
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("{my.custom.template}").addPropertyNode("passengers")
				.addConstraintViolation();

		return false;
	}

}
