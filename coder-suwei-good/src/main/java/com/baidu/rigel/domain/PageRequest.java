/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

/**
 * 分页查询请求基类
 *
 * @author suwei
 *
 */
public class PageRequest extends AbstractPageRequest {

    /**
     * 默认分页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;
    private static final long serialVersionUID = 7105570396282668973L;

    /**
     * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return the
     * first page.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     */
    public PageRequest(int page, int size) {
        super(page, size);
    }

    /**
     * default constructor, and the page
     */
    public PageRequest() {
        super(0, DEFAULT_PAGE_SIZE);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#next()
     */
    @Override
    public Pageable next() {
        return new PageRequest(getPageNum() + 1, getPageSize());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.AbstractPageRequest#previous()
     */
    @Override
    public PageRequest previous() {
        return getPageNum() == 0 ? this : new PageRequest(getPageNum() - 1, getPageSize());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#first()
     */
    @Override
    public Pageable first() {
        return new PageRequest(0, getPageSize());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageRequest)) {
            return false;
        }

        PageRequest that = (PageRequest) obj;
        return super.equals(that);
    }
}
