/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Page Request Test Case for unit test.
 * 
 * @author suwei
 *
 */
public class PageRequestTest {
    /**
     * Test data
     */
    private PageRequest pageRequest;

    /**
     * Initialize the test data.
     */
    @Before
    public void init() {
        pageRequest = new PageRequest();
    }

    /**
     * Test the default value of {@link PageRequest}
     */
    @Test
    public void testDefaultValue() {
        assertEquals(0, pageRequest.getPage());
        assertEquals(PageRequest.DEFAULT_PAGE_SIZE, pageRequest.getPageSize());
        assertEquals(0, pageRequest.getPageNum());
        assertEquals(0, pageRequest.getOffset());
    }

    /**
     * Test create {@link PageRequest} use the specified page number and page size.
     */
    @Test
    public void testCreatePage() {
        pageRequest = new PageRequest(3, 20);
        assertEquals(3, pageRequest.getPage());
        assertEquals(20, pageRequest.getPageSize());
        assertEquals(3, pageRequest.getPageNum());
        assertEquals(60, pageRequest.getOffset());
    }

    /**
     * Test case for {@link PageRequest#next()}
     */
    @Test
    public void testNexPage() {
        pageRequest = (PageRequest) pageRequest.next();
        assertEquals(1, pageRequest.getPage());
        assertEquals(PageRequest.DEFAULT_PAGE_SIZE, pageRequest.getPageSize());
        assertEquals(1, pageRequest.getPageNum());
        assertEquals(10, pageRequest.getOffset());
    }

    /**
     * Test case for {@link PageRequest#first()}
     */
    @Test
    public void testFirstPage() {
        pageRequest = (PageRequest) (new PageRequest(3, 20)).first();
        assertEquals(0, pageRequest.getPage());
        assertEquals(20, pageRequest.getPageSize());
        assertEquals(0, pageRequest.getPageNum());
        assertEquals(0, pageRequest.getOffset());

    }
}
