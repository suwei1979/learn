/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository;

import java.io.Serializable;

/**
 * The Repository for Entity Aggregation
 *
 * @author suwei
 *
 * @param <E> The entity as aggregate root
 * @param <ID> The ID of the entity
 */
public interface Repository<E, ID extends Serializable> {

}
