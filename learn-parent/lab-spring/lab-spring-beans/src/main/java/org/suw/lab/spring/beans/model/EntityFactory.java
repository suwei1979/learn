/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.model;

/**
 * @author suwei
 */
public interface EntityFactory<E> {
    public E create();

    public String entityName();
}
