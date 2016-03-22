/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository;

import java.io.Serializable;

import com.baidu.rigel.domain.Pageable;
import com.baidu.rigel.domain.PagedList;

/**
 * Paging request interface<br>
 * Consumer can declare and bind the types directly, and configure the {@code PagingRepositoryProxyFactory} in the
 * spring container, then the factory will auto detect the fields and generate {@code PagingRepositoryProxy} and inject
 * it as the field value.
 * 
 * @author suwei
 *
 * @param <E> The entity as aggregate root
 * @param <R> The request object.
 * @param <ID> The ID of the entity
 */
public interface PagingRepository<E, R extends Pageable, ID extends Serializable> extends Repository<E, ID> {

    /**
     * Query the list of domain entity according to the given request object,
     *
     * @param pagedRequest the request object which encapsulated the query conditions
     * @return The currently paged list of result or empty if none found.
     */
    PagedList<E> listByPage(R pageRequest);

}
