/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.reflection;

import java.io.Serializable;

/**
 * @author suwei
 *
 */
public interface PagingRepository<E, R extends Pageable, ID extends Serializable> {

    /**
     * @param object
     */
    void listByPage(R request);
    
}
