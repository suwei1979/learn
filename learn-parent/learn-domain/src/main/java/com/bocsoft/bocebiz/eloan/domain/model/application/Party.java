package com.bocsoft.bocebiz.eloan.domain.model.application;

import lombok.Data;

import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;

@Data
public abstract class Party {
    private PartyType partyType;
    private CustomerDecisionInfo creditReport;
}
