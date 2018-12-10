/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.service.event;

import org.suw.learn.domain.service.EntityType;

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
