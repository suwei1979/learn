/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.service.impl;

import org.springframework.stereotype.Service;
import org.suw.learn.domain.service.ConstraintValidatorUsedService;

/**
 * @author suwei
 *
 */
@Service("abcservcie")
public class CosntraintValidatorUsedServiceImpl implements ConstraintValidatorUsedService {

    /* (non-Javadoc)
     * @see org.suw.learn.domain.service.ConstraintValidatorUsedService#test()
     */
    @Override
    public void test() {
        System.out.println("Spring容器可以自动装配在ConstraintValidator中标记为@Autowired的对象，牛掰！");

    }

}
