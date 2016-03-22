/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry.dto;

import com.baidu.rigel.domain.PageRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request Object for dynamic query of industry information.
 * @author suwei
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DynamicListIndustry extends PageRequest {
    /**
     * Generated Serial Version
     */
    private static final long serialVersionUID = 3411850788450295512L;
    /**
     * Query condition: industry code，like
     */
    private String code;
    /**
     * Query condition: industry name，like
     */
    private String name;
    
    /**
     * Query condition: industry level id，equal
     */
    private String level;

    /**
     * Query condition: industry parent code，equal
     */
    private String parentCode;

}
