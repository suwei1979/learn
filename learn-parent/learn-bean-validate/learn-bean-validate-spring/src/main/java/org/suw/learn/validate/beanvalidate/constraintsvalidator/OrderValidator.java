/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.validate.beanvalidate.constraintsvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.suw.learn.domain.model.Order;
import org.suw.learn.validate.beanvalidate.constraints.MasterDataEntity;

/**
 * @author suwei
 *
 */
@Component
public class OrderValidator implements ConstraintValidator<MasterDataEntity, Order> {

    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(MasterDataEntity constraintAnnotation) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(Order value, ConstraintValidatorContext context) {
        System.out.println("-------------------------validating master data entity in specific validator - " + value);
        return false;
    }

}
