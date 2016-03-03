/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository;

import java.io.Serializable;

import com.baidu.rigel.domain.Pageable;
import com.baidu.rigel.domain.PagedList;

/**
 * @author suwei
 *
 */
public interface PagingRepository<E, R extends Pageable, ID extends Serializable> extends Repository<E, ID> {

    /**
     * 根据传入的分页查询对象，进行动态查询
     *
     * @param pagedRequest 分页查询请求
     * @return 分页结果列表
     */
    PagedList<E> listByPage(R pageRequest);

}
