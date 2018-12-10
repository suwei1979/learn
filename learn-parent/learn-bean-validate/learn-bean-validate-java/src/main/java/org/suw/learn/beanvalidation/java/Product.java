/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@BusinessEntity
public class Product { 
    // 必须非空
    @NotEmpty 
    private String productName; 
    // 必须在 8000 至 10000 的范围内
    // @Price 是一个定制化的 constraint 
    @Price 
    private float price; 
 
    }