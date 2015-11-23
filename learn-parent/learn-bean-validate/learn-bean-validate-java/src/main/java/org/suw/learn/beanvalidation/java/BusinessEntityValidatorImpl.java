package org.suw.learn.beanvalidation.java;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BusinessEntityValidatorImpl implements ConstraintValidator<BusinessEntity, Object> {

    @Override
    public void initialize(BusinessEntity constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        log.info("校验失败 - " + value +"");
//      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("error.validate." + value.getClass().getName()).addConstraintViolation();
      log.info(value +" is invalid!");
        return false;
    }

}
