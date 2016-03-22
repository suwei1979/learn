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

    /**
     * the currently page.
     */
    private int page;

    /**
     * the currently page size.
     */
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

    public int getPageNum() {
        return page;
    }

    /**
     * Set the page number
     *
     * @param page the page number.
     */
    public void setPageNum(int page) {
        this.page = page;
    }

    public int getOffset() {
        return page * size;
    }

    public boolean hasPrevious() {
        return page > 0;
    }

    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    public abstract Pageable next();

    /**
     * Returns the {@link Pageable} requesting the previous {@link Page}.
     *
     * @return the previous pageable.
     */
    public abstract Pageable previous();

    public abstract Pageable first();

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = (prime * result) + page;
        result = (prime * result) + size;

        return result;
    }

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