/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

import java.util.List;

/**
 * Paged List Interface.
 *
 * @author suwei
 *
 */
public interface PagedList<T> extends Iterable<T> {
    /**
     * The total pages
     *
     * @return the number of total pages
     */
    int getTotalPages();

    /**
     * The total elements of the request
     *
     * @return the total amount of elements
     */
    long getTotalElements();

    /**
     * Page number of the current page.
     *
     * @return the number of the current {@link PagedList}.
     */
    int getNumber();

    /**
     * The page size
     *
     * @return the size of the {@link PagedList}.
     */
    int getSize();

    /**
     * The total elements of the currently {@link PagedList}.
     *
     * @return the number of elements currently on this {@link PagedList}.
     */
    int getNumberOfElements();

    /**
     * The content list（Usually The T should be the domain object）
     * 
     * @return The content list of the currently paged list.
     */
    List<T> getContent();

    /**
     * Whether the currently list has contents at all.
     *
     * @return Whether the currently list has contents.
     */
    boolean hasContent();

    /**
     * Whether the paged list is the first one.
     *
     * @return
     */
    boolean isFirst();

    /**
     * Whether the paged list is the last one.
     *
     * @return
     */
    boolean isLast();

    /**
     * Whether the list has next page at all.
     *
     * @return if there is a next {@link PagedList}.
     */
    boolean hasNext();

    /**
     * Whether the list has previous at all.
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
