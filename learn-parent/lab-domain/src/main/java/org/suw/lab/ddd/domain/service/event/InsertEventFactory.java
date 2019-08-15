/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service.event;

/**
 * @author suwei
 */
public class InsertEventFactory {

    /**
     * @return
     */
    public static <T> EntityEvent<T> create(T domainObject) {
        // TODO Auto-generated provider stub
        return new InsertEvent<>(domainObject);
    }

}
