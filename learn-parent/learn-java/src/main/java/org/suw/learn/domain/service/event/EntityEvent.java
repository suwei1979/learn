/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.service.event;

import org.suw.learn.domain.service.EntityType;

/**
 * @author suwei
 *
 */
public interface EntityEvent<T> {
    EntityType getMetaType();
    T getData();
//    public static abstract <E extends EntityEvent> E create();
}
