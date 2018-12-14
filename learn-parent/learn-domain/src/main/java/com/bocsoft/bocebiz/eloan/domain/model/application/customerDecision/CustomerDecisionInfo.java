/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import java.util.List;

import com.bocsoft.bocebiz.eloan.domain.model.PersonId;
import com.bocsoft.bocebiz.eloan.domain.model.application.Platform;

import lombok.Data;

@Data
public class CustomerDecisionInfo {
    private Platform platformInfo;

    private String platformSeqNo;
    private String productCode;

    private PersonId personIdInfo;

    private String loanQuantity;//贷款信息循环个数
    private String limitQuantity;//额度信息循环个数
    private String transLoanQuantity;//在途贷款信息循环个数
    private String warnQuantity;//预警信息信息循环个数

    private List<LoanItem> loanInfoItems;
    private List<LimitItem> limitInfoItems;
    private List<TransLoanItem> transLoanItems;
    private List<WarnItem> warnItems;
    private CreditInfoReport creditInfoReport;
}
