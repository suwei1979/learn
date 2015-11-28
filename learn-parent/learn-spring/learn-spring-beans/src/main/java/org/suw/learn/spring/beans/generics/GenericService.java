/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.generics;

/**
 * @author suwei
 *
 */
public interface GenericService<E> {
    public E insert(E entity);
    
}
