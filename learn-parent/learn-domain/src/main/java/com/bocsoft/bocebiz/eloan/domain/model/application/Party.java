/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.application;

import lombok.Data;

import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;

@Data
public abstract class Party {
    private PartyType partyType;
    private CustomerDecisionInfo creditReport;
}
