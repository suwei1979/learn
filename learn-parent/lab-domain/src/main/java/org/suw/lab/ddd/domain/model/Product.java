/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.suw.lab.ddd.validation.constraints.Price;

import lombok.Data;

@Data
public class Product {
    // 必须非空
    @NotEmpty
    private String productName;
    // 必须在 8000 至 10000 的范围内
    // @Price 是一个定制化的 constraint 
    @Price
    private float price;

}