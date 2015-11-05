package org.suw.learn.validate.beanvalidate.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import org.suw.learn.validate.beanvalidate.constraintsvalidator.ZipCodeValidator;

@Documented
@Pattern(regexp = "[0-9]*")
@Constraint(validatedBy = {ZipCodeValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface ZipCode {
    String countryCode();

    String message() default "{com.acme.constraint.ZipCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several @ZipCode annotations on the same element
     * @see (@link ZipCode}
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ZipCode[] value();
    }    

}
