/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service.impl;

import org.springframework.stereotype.Service;
import org.suw.lab.ddd.domain.service.ConstraintValidatorUsedService;

/**
 * @author suwei
 */
@Service("abcservcie")
public class CosntraintValidatorUsedServiceImpl implements ConstraintValidatorUsedService {

    /* (non-Javadoc)
     * @see org.suw.learn.ConstraintValidatorUsedService#test()
     */
    @Override
    public void test() {
        System.out.println("-------------------------custom validation processing");

    }

}
