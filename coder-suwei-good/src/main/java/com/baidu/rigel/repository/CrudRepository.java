/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository;

import java.io.Serializable;

/**
 * 单实体增删改查Repository
 *
 * @author suwei
 *
 */

public interface CrudRepository<E, ID extends Serializable> extends Repository<E, ID> {

    /**
     * 向底层存储插入一个实体
     *
     * @param entity
     * @return
     */
    public E insert(E entity);

    /**
     * 根据ID从数据库找回实体
     *
     * @param id
     * @return 对应的实体
     */
    public E retrieve(ID id);

    /**
     * 以实体的值作为条件，查找并返回一个实体。如果找到了多个对象，只返回匹配的第一个对象
     *
     * @param entity
     * @return
     */
    public E retrieve(E entity);

    /**
     * 更新一个实体
     *
     * @param entity
     * @return
     */
    public E update(E entity);

    /**
     *
     * @param id
     * @return
     */
    public E delete(ID id);
}
