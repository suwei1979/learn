/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.suw.learn.validation.Price;

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