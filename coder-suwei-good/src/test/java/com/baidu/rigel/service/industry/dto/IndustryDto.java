/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author suwei
 *
 */
@Data
public class IndustryDto implements Serializable {
    private static final long serialVersionUID = 7131525572473700486L;
    private String name;
    private String code;
    private String parentCode;
}
