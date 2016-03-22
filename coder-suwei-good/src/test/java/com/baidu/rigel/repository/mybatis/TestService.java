/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import org.springframework.stereotype.Service;

import com.baidu.rigel.domain.PagedList;
import com.baidu.rigel.repository.PagingRepository;

/**
 * Test Service for Account.
 * 
 * @author suwei
 *
 */
@Service
public class TestService {
    PagingRepository<Account, TestPageRequest, Long> listRepository;

    /**
     * List account by id and code
     * 
     * @param request query conditions
     * @return the account list, empty list if none found.
     */
    public PagedList<Account> listByPage(TestPageRequest request) {
        return listRepository.listByPage(request);
    }
}
