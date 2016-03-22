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
 * Paged List Implementation
 *
 * @author suwei
 *
 */
public class PagedListImpl<T> implements PagedList<T>, Serializable {

    /**
     * Generated serial version id.
     */
    private static final long serialVersionUID = 7129008327726721057L;

    /**
     * the content of current paged list.
     */
    private final List<T> content = new ArrayList<T>();

    /**
     * The current page information.
     */
    private final Pageable pageable;

    /**
     * The total elements of the whole list.
     */
    private final long totalElement;

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
        // adjust the total value：
        // 1. 当前的内容不为空、并且分页对象不为空，并且分页对象的位移与分页大小之和大于总数时，取位移+当前页
        // 内容大小之和作为所有元素的统计结果
        // 2. 否则返回total的值
        this.totalElement =
                !content.isEmpty() && (pageable != null) && ((pageable.getOffset() + pageable.getPageSize()) > total)
                        ? pageable.getOffset() + content.size() : total;
    }

    public Pageable currentPageable() {
        return pageable;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PagedListImpl<?>)) {
            return false;
        }

        PagedListImpl<?> that = (PagedListImpl<?>) obj;

        return (this.totalElement == that.totalElement) && super.equals(obj);
    }

    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    public int getNumber() {
        return null == pageable ? 0 : pageable.getPageNum();
    }

    public int getNumberOfElements() {
        return content.size();
    }

    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    public long getTotalElements() {
        return totalElement;
    }

    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) totalElement / (double) getSize());
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }

    @Override
    public int hashCode() {

        int result = 17;

        result += 31 * (int) (totalElement ^ (totalElement >>> 32));
        result += 31 * super.hashCode();

        return result;
    }

    public boolean hasNext() {
        return (getNumber() + 1) < getTotalPages();
    }

    public boolean hasPrevious() {
        return getNumber() > 0;
    }

    public boolean isFirst() {
        return !hasPrevious();
    }

    public boolean isLast() {
        return !hasNext();
    }

    public Iterator<T> iterator() {
        return content.iterator();
    }

    public Pageable nextPageable() {
        return hasNext() ? pageable.next() : null;
    }

    public Pageable previousPageable() {
        return hasPrevious() ? pageable.previousOrFirst() : null;
    }

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
