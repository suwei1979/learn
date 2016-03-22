/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import com.baidu.rigel.domain.PageRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Test Class for Customized PageRequest.
 * @author suwei
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TestPageRequest extends PageRequest {

    /**
     * Generated serial version id
     */
    private static final long serialVersionUID = -6846006035895088208L;
    /**
     * Account id, used as query condition.
     */
    private Long id;
    
    /**
     * Account name, used as query condition, fuzzy query
     */
    private String name;

}
