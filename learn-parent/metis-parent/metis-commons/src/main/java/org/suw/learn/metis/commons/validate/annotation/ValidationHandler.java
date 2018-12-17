/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.validate.annotation;

import java.lang.annotation.*;

/**
 * Annotation for aspect to handle validation errors.
 * This annotation can be set on class or method level.
 * Validation is needed in both presentation layer and
 * business layer.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ValidationHandler {

    Layer layer() default Layer.CONTROLLER;

    enum Layer {
        CONTROLLER,DUBBOSERVICE,SERVICE
    }
}
