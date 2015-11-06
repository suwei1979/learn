package org.suw.learn.validate.beanvalidate.constraints;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.suw.learn.validate.beanvalidate.constraintsvalidator.OrderNumberValidator;

@Documented
@Constraint(validatedBy = { OrderNumberValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderNumber {
    String message() default "{com.acme.constraint.OrderNumber.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
