package org.suw.learn.validate.beanvalidate.constraintsvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.suw.learn.domain.service.ConstraintValidatorUsedService;
import org.suw.learn.validate.beanvalidate.constraints.ZipCode;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Autowired
    private ConstraintValidatorUsedService constraintValidatorUsedService;
	@Override
	public void initialize(ZipCode constraintAnnotation) {
	    System.out.println(constraintAnnotation.annotationType().getName() + " validator initialized!");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    System.out.println(context.toString());
		// context.disableDefaultConstraintViolation();
		// context.buildConstraintViolationWithTemplate("Increct zipcode").addBeanNode().inIterable().atKey("home").addConstraintViolation();
		// System.out.println(context.getDefaultConstraintMessageTemplate());
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("{my.custom.template}").addPropertyNode("passengers")
				.addConstraintViolation();
		constraintValidatorUsedService.test();
		return true;
	}

}
