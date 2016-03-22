/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.rigel.ITContext;

/**
 * PagingRepositoryProxy Test Cases
 * 
 * @author suwei
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = { "classpath:/conf/applicationContext.xml" })
public class PagingRepositoryProxyTest extends ITContext {

    /**
     * Test Service.
     */
    @Autowired
    private TestService testService;

    /**
     * Assertions for init test context.
     */
    @Before
    public void init() {
        assertNotNull("TestService should be autowired already", testService);
    }

    /**
     * Test the proxy autowire result, success when no execptions are throwed.
     */
    @Test
    public void testProxyAutowire() {
        assertNotNull("listRepository should be initialized already!", testService.listRepository);
        TestPageRequest request = new TestPageRequest();
        testService.listByPage(request);
    }

}
