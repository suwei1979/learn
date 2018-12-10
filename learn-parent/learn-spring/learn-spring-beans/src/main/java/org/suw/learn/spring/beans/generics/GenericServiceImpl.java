/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.generics;

import org.suw.learn.spring.beans.model.EntityFactory;

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
     * @see org.suw.learn.spring.beans.generics.GenericService#insert(java.lang.Object)
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
