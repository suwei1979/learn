/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service.event;

import org.suw.lab.ddd.domain.service.EntityType;

/**
 * @author suwei
 */
public interface EntityEvent<T> {
    EntityType getMetaType();

    T getData();
    //    public static abstract <E extends EntityEvent> E create();
}
