/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.generics;

import org.suw.lab.spring.beans.model.EntityFactory;

/**
 * @author suwei
 */
public class GenericServiceImpl<E> implements GenericService<E> {
    private EntityFactory<E> entityFactory;
    private Class<E> entityClass;

    public GenericServiceImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * @param entityFactory the entityFactory to set
     */
    @Override
    public void setEntityFactory(EntityFactory<E> entityFactory) {
        this.entityFactory = entityFactory;
    }

    /**
     * (non-Javadoc)
     *
     * @see GenericService#insert(java.lang.Object)
     */
    @Override
    public E insert(E entity) {
        // TODO Auto-generated provider stub
        return entityFactory.create();
    }

    /*
     * (non-Javadoc)
     *
     * @see EntityTypeResolvable#getEntityType()
     */
    @Override
    public Class<E> getEntityType() {
        return entityClass;
    }

}
