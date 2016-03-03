/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.baidu.rigel.util.Asserts;

/**
 * 分页列表实现
 *
 * @author suwei
 *
 */
public class PagedListImpl<T> implements PagedList<T>, Serializable {

    private static final long serialVersionUID = 7129008327726721057L;
    private final List<T> content = new ArrayList<T>();
    private final Pageable pageable;
    private final long total;

    /**
     * Creates a new {@link PagedListImpl} with the given content. This will result in the created {@link PageList}
     * being identical to the entire {@link List}.
     *
     * @param content must not be {@literal null}.
     */
    public PagedListImpl(List<T> content) {
        this(content, null, null == content ? 0 : content.size());
    }

    /**
     * Constructor of {@code PagedListImpl}.
     *
     * @param content the content of this page, must not be {@literal null}.
     * @param pageable the paging information, can be {@literal null}.
     * @param total the total amount of items available. The total might be adapted considering the length of the
     *            content given, if it is going to be the content of the last page. This is in place to mitigate
     *            inconsistencies
     */
    public PagedListImpl(List<T> content, Pageable pageable, long total) {

        Asserts.notNull(content, "Content must not be null!");

        this.content.addAll(content);
        this.pageable = pageable;
        this.total =
                !content.isEmpty() && (pageable != null) && ((pageable.getOffset() + pageable.getPageSize()) > total)
                        ? pageable.getOffset() + content.size() : total;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#currentPageable()
     */
    public Pageable currentPageable() {
        return pageable;
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

        if (!(obj instanceof PagedListImpl<?>)) {
            return false;
        }

        PagedListImpl<?> that = (PagedListImpl<?>) obj;

        return (this.total == that.total) && super.equals(obj);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain#getContent()
     */
    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#getNumber()
     */
    public int getNumber() {
        return pageable == null ? 0 : pageable.getPageNum();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#getNumberOfElements()
     */
    public int getNumberOfElements() {
        return content.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#getSize()
     */
    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    /**
     * getter method for property total
     *
     * @return the total
     */
    public long getTotal() {
        return total;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#getTotalElements()
     */
    public long getTotalElements() {
        return total;
    }

    /*
     * (non-Javadoc)
     *
     * @see PagedList#getTotalPages()
     */
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#hasContent()
     */
    public boolean hasContent() {
        return !content.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result += 31 * (int) (total ^ (total >>> 32));
        result += 31 * super.hashCode();

        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#hasNext()
     */
    public boolean hasNext() {
        return (getNumber() + 1) < getTotalPages();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#hasPrevious()
     */
    public boolean hasPrevious() {
        return getNumber() > 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#isFirst()
     */
    public boolean isFirst() {
        return !hasPrevious();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#isLast()
     */
    public boolean isLast() {
        return !hasNext();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<T> iterator() {
        return content.iterator();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#nextPageable()
     */
    public Pageable nextPageable() {
        return hasNext() ? pageable.next() : null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baidu.rigel.domain.PagedList#previousPageable()
     */
    public Pageable previousPageable() {
        return hasPrevious() ? pageable.previousOrFirst() : null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String contentType = "UNKNOWN";
        List<T> content = getContent();

        if (content.size() > 0) {
            contentType = content.get(0).getClass().getName();
        }

        return String.format("Page %s of %d containing %s instances", getNumber(), getTotalPages(), contentType);
    }

}
