/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.service.impl;

import org.springframework.stereotype.Service;
import org.suw.learn.domain.service.ConstraintValidatorUsedService;

/**
 * @author suwei
 */
@Service("abcservcie")
public class CosntraintValidatorUsedServiceImpl implements ConstraintValidatorUsedService {

    /* (non-Javadoc)
     * @see org.suw.learn.domain.service.ConstraintValidatorUsedService#test()
     */
    @Override
    public void test() {
        System.out.println("-------------------------custom validation processing");

    }

}
