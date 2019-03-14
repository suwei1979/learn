/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.service;

/**
 * @author suwei
 */
public interface EntityManager<T> {
    public T insert(T entity);

    public T update(T entity);
}
