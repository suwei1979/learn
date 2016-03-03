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
 * PagingRepositoryProxy测试类
 * @author suwei
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
public class PagingRepositoryProxyTest extends ITContext {

    @Autowired
    private TestService testService;
    
    @Before
    public void init() {
        assertNotNull("TestService should be autowired already", testService);
    }
    
    @Test
    public void testProxyAutowire() {
        assertNotNull("", testService.listRepository);
        TestPageRequest request = new TestPageRequest();
        testService.listByPage(request);
    }
   
    
}
