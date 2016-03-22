/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Data Transfer Object of industry<br>
 * use to encapsulate the industry item.
 * 
 * @author suwei
 *
 */
@Data
public class IndustryDto implements Serializable {
    private static final long serialVersionUID = 7131525572473700486L;
    /**
     * name of industry
     */
    private String name;
    
    /**
     * code of industry
     */
    private String code;
    
    /**
     * code of the parent industry.
     */
    private String parentCode;
}
