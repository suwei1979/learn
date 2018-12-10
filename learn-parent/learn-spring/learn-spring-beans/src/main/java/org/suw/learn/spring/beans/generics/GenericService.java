/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans.generics;

/**
 * @author suwei
 *
 */
public interface GenericService<E> extends EntityTypeResolvable<E> {
    public E insert(E entity);

}
