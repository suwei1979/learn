/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.application;

import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;

import lombok.Data;

@Data
public abstract class Party {
    private PartyType partyType;
    private CustomerDecisionInfo creditReport;
}
