/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
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
    private CalculateOperationBranchPolicy calculateOperationBranchPolicy;

}
