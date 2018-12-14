/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.contract;

import com.bocsoft.bocebiz.eloan.domain.model.application.ProductType;

import lombok.Data;

@Data
public class ContractTemplate {
    private ProductType product;
    private String templateId;//模板Id
    private String contractContext;//合同模板内容
    //根据产品，取模板的规则或处理

}
