/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.generics;

/**
 * @author suwei
 */
public interface GenericService<E> extends EntityTypeResolvable<E> {
    public E insert(E entity);

}
