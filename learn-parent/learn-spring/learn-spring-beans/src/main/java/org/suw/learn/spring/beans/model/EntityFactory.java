/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

/**
 * @author suwei
 */
public interface EntityFactory<E> {
    public E create();

    public String entityName();
}
