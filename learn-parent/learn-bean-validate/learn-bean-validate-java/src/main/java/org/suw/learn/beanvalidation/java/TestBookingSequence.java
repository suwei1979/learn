package org.suw.learn.beanvalidation.java;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { DefaultBookingSequenceValidator.class })
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TestBookingSequence {
    String message() default "实体簿记流程";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
