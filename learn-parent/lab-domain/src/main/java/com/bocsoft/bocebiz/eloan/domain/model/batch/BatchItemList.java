/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.batch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BatchItemList<T> implements Iterable<T> {
    private ArrayList<T> items;
    private int batchSize;

    public BatchItemList(int batchSize) {
        this.batchSize = batchSize;
    }

    public void add(T item) {
        items.add(item);
    }

    public void addAll(Collection<T> itemList) {
        items.addAll(itemList);
    }

    public T get(int idx) {
        return items.get(idx);
    }

    public int size() {
        return items.size();
    }

    public int getBatchSize() {
        return batchSize;
    }

    @Override
    public Iterator<T> iterator() {

        return items.iterator();
    }
}
