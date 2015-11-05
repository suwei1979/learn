package com.bocsoft.bocebiz.eloan.domain.model.contract;

import lombok.Data;

import com.bocsoft.bocebiz.eloan.domain.model.application.ProductType;

@Data
public class ContractTemplate {
	private ProductType product;
	private String templateId;//模板Id
	private String contractContext;//合同模板内容
	//根据产品，取模板的规则或处理
	
}
