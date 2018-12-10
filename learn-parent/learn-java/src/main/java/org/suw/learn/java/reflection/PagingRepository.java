/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.reflection;

import java.io.Serializable;

/**
 * @author suwei
 */
public interface PagingRepository<E, R extends Pageable, ID extends Serializable> {

    /**
     * @param object
     */
    void listByPage(R request);

    void testNoArgs();

}
