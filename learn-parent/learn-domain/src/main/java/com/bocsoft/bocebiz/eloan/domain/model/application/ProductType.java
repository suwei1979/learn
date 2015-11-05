package com.bocsoft.bocebiz.eloan.domain.model.application;

import lombok.Data;

@Data
public class ProductType {
	private String productCode;
	private Rate baseRate;
	private String description;
	private AsignOperationBranchPolicy asignOperationBranchPolicy;
	private PricingStrategy pricingStrategy;
	private PartyType partyType;
}
