/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domain.service.event;

/**
 * @author suwei
 *
 */
public class InsertEventFactory {

    /**
     * @return
     */
    public static <T> EntityEvent<T> create(T domainObject) {
        // TODO Auto-generated method stub
        return new InsertEvent<>(domainObject);
    }

}
