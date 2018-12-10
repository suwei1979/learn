/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {BusinessEntityValidatorImpl.class })
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessEntity {
    String message() default "消息模板应定义为错误代码，然后通过获取interpolatedMessage来得到错误码，进而通过资源束来动态调整错误消息";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
