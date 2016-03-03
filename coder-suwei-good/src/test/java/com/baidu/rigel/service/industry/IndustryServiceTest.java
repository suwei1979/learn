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
 * @author suwei
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
public class IndustryServiceTest extends ITContext {

    @Autowired
    IndustryService industryService;
    DynamicListIndustry dynamicRequest;
    
    @Before
    public void init() {
        dynamicRequest = new DynamicListIndustry();
    }
    
    @Test
    public void testListByPage() {
        industryService.findByList(dynamicRequest);
    }
}
