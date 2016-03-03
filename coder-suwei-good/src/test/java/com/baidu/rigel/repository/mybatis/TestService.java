/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import org.springframework.stereotype.Service;

import com.baidu.rigel.domain.PagedList;
import com.baidu.rigel.repository.PagingRepository;

/**
 * @author suwei
 *
 */
@Service
public class TestService {
    PagingRepository<Account, TestPageRequest, Long> listRepository;
    
    public PagedList<Account> listByPage(TestPageRequest request) {
        return listRepository.listByPage(request);
    }
}
