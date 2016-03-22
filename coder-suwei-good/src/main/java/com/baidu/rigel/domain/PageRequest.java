/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

/**
 * The basic implementation of PagedList
 *
 * @author suwei
 *
 */
public class PageRequest extends AbstractPageRequest {

    /**
     * The default value of page size
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

    @Override
    public Pageable next() {
        return new PageRequest(getPageNum() + 1, getPageSize());
    }

    @Override
    public PageRequest previous() {
        return getPageNum() == 0 ? this : new PageRequest(getPageNum() - 1, getPageSize());
    }

    @Override
    public Pageable first() {
        return new PageRequest(0, getPageSize());
    }

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
