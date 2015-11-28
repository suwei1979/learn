/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
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
