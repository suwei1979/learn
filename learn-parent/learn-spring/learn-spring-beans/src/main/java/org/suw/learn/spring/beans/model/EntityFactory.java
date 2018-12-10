/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

/**
 * @author suwei
 */
public interface EntityFactory<E> {
    public E create();

    public String entityName();
}
