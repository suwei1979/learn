/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

import java.io.Serializable;

/**
 * Abstract Java Bean implementation of {@code Pageable}.
 *
 * @author suwei
 */
public abstract class AbstractPageRequest implements Pageable, Serializable {

    /**
     * Generated Serial Version UUID
     */
    private static final long serialVersionUID = -227712514337968827L;
    private int page;
    private int size;

    /**
     * Creates a new {@link AbstractPageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return
     * the first page.
     *
     * @param page must not be less than zero.
     * @param size must not be less than one.
     */
    public AbstractPageRequest(int page, int size) {

        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }

        this.page = page;
        this.size = size;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#getPageSize()
     */
    public int getPageSize() {
        return size;
    }

    /**
     * 设置分页大小
     *
     * @param size
     */
    public void setPageSize(int size) {
        this.size = size;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#getPageNumber()
     */
    public int getPageNum() {
        return page;
    }

    /**
     * 设置当前页
     *
     * @param size
     */
    public void setPageNum(int page) {
        this.page = page;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#getOffset()
     */
    public int getOffset() {
        return page * size;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#hasPrevious()
     */
    public boolean hasPrevious() {
        return page > 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#previousOrFirst()
     */
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#next()
     */
    public abstract Pageable next();

    /**
     * Returns the {@link Pageable} requesting the previous {@link Page}.
     *
     * @return
     */
    public abstract Pageable previous();

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.trustvocrm.domain.Pageable#first()
     */
    public abstract Pageable first();

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = (prime * result) + page;
        result = (prime * result) + size;

        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        AbstractPageRequest other = (AbstractPageRequest) obj;
        return (this.page == other.page) && (this.size == other.size);
    }

    /**
     * getter method for property page
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * getter method for property size
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

}