/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.generics;

import org.suw.lab.spring.beans.model.EntityFactory;

/**
 * @author suwei
 */
public interface EntityTypeResolvable<E> {
    Class<E> getEntityType();

    /**
     * @param entityFactory
     */
    void setEntityFactory(EntityFactory<E> entityFactory);
}
