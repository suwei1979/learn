/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service.event;


import org.suw.lab.ddd.domain.service.EntityType;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author suwei
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class InsertEvent<T> implements EntityEvent<T> {
    private final T data;

    /* (non-Javadoc)
     * @see org.suw.learn.domain.service.EntityEvent#getMetaType()
     */
    @Override
    public EntityType getMetaType() {
        // TODO Auto-generated provider stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.suw.learn.domain.service.EntityEvent#getData()
     */
    @Override
    public T getData() {
        // TODO Auto-generated provider stub
        return null;
    }

}
