/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.rigel.ITContext;
import com.baidu.rigel.service.industry.dto.DynamicListIndustry;

/**
 * 使用PagingRepository的场景示例
 * Use IndustryService to simulate the scenario of PagingRepository.
 * @author suwei
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = { "classpath:/conf/applicationContext.xml" })
public class IndustryServiceTest extends ITContext {

    /**
     * Industry Service that use PagingRepository as query implementation.
     */
    @Autowired
    IndustryService industryService;
    
    /**
     * Query Conditions
     */
    DynamicListIndustry dynamicRequest;

    /**
     * Init the query conditons
     */
    @Before
    public void init() {
        dynamicRequest = new DynamicListIndustry();
    }

    /**
     * Test Case for {@link IndustryService#findByList(DynamicListIndustry)}
     */
    @Test
    public void testListByPage() {
        industryService.findByList(dynamicRequest);
    }
}
