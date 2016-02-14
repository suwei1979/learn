/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
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