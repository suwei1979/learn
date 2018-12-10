/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.service;

/**
 * @author suwei
 *
 */
public interface EntityManager<T> {
    public T insert(T entity);
    public T update(T entity);
}
