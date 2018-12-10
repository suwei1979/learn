/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.suw.learn.mdm.spi.ServiceLocator;
import org.suw.learn.validation.constraints.MasterDataEntity;

/**
 * @author suwei
 */
public class MasterDataEntityValidator implements ConstraintValidator<MasterDataEntity, Object> {

    @Autowired
    private ServiceLocator validatorLocator;

    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(MasterDataEntity constraintAnnotation) {
        // TODO Auto-generated provider stub

    }

    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("-------------------------validating master data entity - " + value);
        @SuppressWarnings("unchecked")
        ConstraintValidator<MasterDataEntity, Object> customValidator =
                validatorLocator.create(ConstraintValidator.class, MasterDataEntity.class, value.getClass());

        return customValidator != null ? customValidator.isValid(value, context) : true;
    }

}
