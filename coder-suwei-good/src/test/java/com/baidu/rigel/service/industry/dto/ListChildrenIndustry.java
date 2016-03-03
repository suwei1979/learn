/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry.dto;

import com.baidu.rigel.domain.PageRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author suwei
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ListChildrenIndustry extends PageRequest {
    private static final long serialVersionUID = 983809832821845996L;
    
    /**
     * 查询条件：上级行业代码
     */
    private String parentCode;
}
