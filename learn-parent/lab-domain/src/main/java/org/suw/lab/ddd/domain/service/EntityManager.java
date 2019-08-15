/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service;

/**
 * @author suwei
 */
public interface EntityManager<T> {
    public T insert(T entity);

    public T update(T entity);
}
