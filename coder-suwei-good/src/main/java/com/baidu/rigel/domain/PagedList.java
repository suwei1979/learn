/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

import java.util.List;

/**
 * 分页列表
 *
 * @author suwei
 *
 */
public interface PagedList<T> extends Iterable<T> {
    /**
     * 返回总页数
     *
     * @return the number of toral pages
     */
    int getTotalPages();

    /**
     * 返回总记录数
     *
     * @return the total amount of elements
     */
    long getTotalElements();

    /**
     * 返回当前所在的页
     *
     * @return the number of the current {@link PagedList}.
     */
    int getNumber();

    /**
     * 返回分页的大小
     *
     * @return the size of the {@link PagedList}.
     */
    int getSize();

    /**
     * 返回当前分页的元素数量
     *
     * @return the number of elements currently on this {@link PagedList}.
     */
    int getNumberOfElements();

    /**
     * 返回内容列表（通常应为领域对象）
     *
     * @return
     */
    List<T> getContent();

    /**
     * 返回是否包含内容
     *
     * @return
     */
    boolean hasContent();

    /**
     * 返回当前列表是否最前一页
     *
     * @return
     */
    boolean isFirst();

    /**
     * 返回当前列表是否最后一页
     *
     * @return
     */
    boolean isLast();

    /**
     * 返回是否包含下一页
     *
     * @return if there is a next {@link PagedList}.
     */
    boolean hasNext();

    /**
     * 返回是否有上一页
     *
     * @return if there is a previous {@link PagedList}.
     */
    boolean hasPrevious();

    /**
     * Returns the {@link Pageable} to request the next {@link PagedList}. Can be {@literal null} in case the current
     * {@link PagedList} is already the last one. Clients should check {@link #hasNext()} before calling this method to
     * make sure they receive a non-{@literal null} value.
     *
     * @return
     */
    Pageable nextPageable();

    /**
     * Returns the {@link Pageable} to request the previous {@link PagedList}. Can be {@literal null} in case the
     * current {@link PagedList} is already the first one. Clients should check {@link #hasPrevious()} before calling
     * this method make sure receive a non-{@literal null} value.
     *
     * @return
     */
    Pageable previousPageable();

    /**
     * Returns the {@link Pageable} of current {@link PagedList}.
     *
     * @return Current Pageable
     */
    Pageable currentPageable();

}
