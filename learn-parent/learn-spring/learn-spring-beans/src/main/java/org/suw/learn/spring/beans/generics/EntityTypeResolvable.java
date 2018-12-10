/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans.generics;

import org.suw.learn.spring.beans.model.EntityFactory;

/**
 * @author suwei
 *
 */
public interface EntityTypeResolvable<E> {
    Class<E> getEntityType();

    /**
     * @param entityFactory
     */
    void setEntityFactory(EntityFactory<E> entityFactory);
}
