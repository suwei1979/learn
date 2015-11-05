package org.suw.learn.validate.beanvalidate.constraintsvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.validate.beanvalidate.constraints.OrderNumber;

public class OrderNumberValidator implements ConstraintValidator<OrderNumber, String> {

	@Override
	public void initialize(OrderNumber constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
