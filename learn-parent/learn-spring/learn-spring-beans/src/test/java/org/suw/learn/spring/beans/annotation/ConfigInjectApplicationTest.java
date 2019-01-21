/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.suw.learn.spring.beans.LearnSpringBeansApplication;

/**
 * @classname: ConfigInjectApplicationTest
 * @author: suwei
 * @description:
 * @date: created in 2019/1/8 : 7:25 PM
 * @modified
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBeansApplication.class)
public class ConfigInjectApplicationTest {

    @Autowired
    private BeanWithInjectProperties beanWithInjectProperties;

    @Test
    public void testBeanValueInject() {
        System.out.println(beanWithInjectProperties.toString());
    }
}
