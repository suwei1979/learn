/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

/**
 * @author suwei
 *
 */
public interface EntityFactory<E> {
    public E create();

    public String entityName();
}
