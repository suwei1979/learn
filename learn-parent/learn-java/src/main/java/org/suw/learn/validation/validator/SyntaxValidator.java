/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validation.validator;

import java.text.Format;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.suw.learn.validation.constraints.Syntax;

public class SyntaxValidator implements ConstraintValidator<Syntax, String> {
    private Set<Format> allowedFormats;

    @Override
    public void initialize(Syntax constraintAnnotation) {
        //		allowedFormats = new HashSet<Format>(Arrays.asList())

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated provider stub
        return false;
    }

}
