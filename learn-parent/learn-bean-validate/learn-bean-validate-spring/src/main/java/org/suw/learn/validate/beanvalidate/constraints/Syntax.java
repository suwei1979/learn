package org.suw.learn.validate.beanvalidate.constraints;

import java.lang.annotation.Documented;

import javax.validation.Constraint;

import org.suw.learn.validate.beanvalidate.constraintsvalidator.SyntaxValidator;

@Documented
@Constraint(validatedBy = { SyntaxValidator.class })
public @interface Syntax {
	String message() default "wrong detailed text format";
	

}
