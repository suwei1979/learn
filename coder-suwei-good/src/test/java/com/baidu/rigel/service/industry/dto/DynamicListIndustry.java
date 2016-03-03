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
public class DynamicListIndustry extends PageRequest {
    /**
     * 
     */
    private static final long serialVersionUID = 3411850788450295512L;
    /**
     * 查询条件：行业代码，like
     */
    private String code;
    /**
     * 查询条件：行业名称，like
     */
    private String name;
    
    private String level;
    
    private String parentCode;

}
