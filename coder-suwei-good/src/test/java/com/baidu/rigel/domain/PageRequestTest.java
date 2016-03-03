/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Page Request 单测案例
 * @author suwei
 *
 */
public class PageRequestTest {
    private PageRequest pageRequest;
    
    @Before
    public void init() {
        pageRequest = new PageRequest();
    }
    
    @Test
    public void testDefaultValue() {
        assertEquals(0, pageRequest.getPage());
        assertEquals(PageRequest.DEFAULT_PAGE_SIZE, pageRequest.getPageSize());
        assertEquals(0, pageRequest.getPageNum());
        assertEquals(0, pageRequest.getOffset());
    }
    
    @Test
    public void testCreatePage() {
        pageRequest = new PageRequest(3, 20);
        assertEquals(3, pageRequest.getPage());
        assertEquals(20, pageRequest.getPageSize());
        assertEquals(3, pageRequest.getPageNum());
        assertEquals(60, pageRequest.getOffset());
    }
    
    @Test
    public void testNexPage() {
        pageRequest = (PageRequest) pageRequest.next();
        assertEquals(1, pageRequest.getPage());
        assertEquals(PageRequest.DEFAULT_PAGE_SIZE, pageRequest.getPageSize());
        assertEquals(1, pageRequest.getPageNum());
        assertEquals(10, pageRequest.getOffset());
    }
    
    @Test
    public void testFirstPage() {
        pageRequest = (PageRequest) (new PageRequest(3, 20)).first();
        assertEquals(0, pageRequest.getPage());
        assertEquals(20, pageRequest.getPageSize());
        assertEquals(0, pageRequest.getPageNum());
        assertEquals(0, pageRequest.getOffset());
        
    }
}
