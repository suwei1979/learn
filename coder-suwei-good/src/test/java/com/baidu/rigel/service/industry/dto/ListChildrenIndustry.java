/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry.dto;

import com.baidu.rigel.domain.PageRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request object that encapsulated the query conditions of the direct sub-industry.
 * 
 * @author suwei
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ListChildrenIndustry extends PageRequest {
    private static final long serialVersionUID = 983809832821845996L;

    /**
     * Query condition: the code of parent industry, equal.
     */
    private String parentCode;
}
