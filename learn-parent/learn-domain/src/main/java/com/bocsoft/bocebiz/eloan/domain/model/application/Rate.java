/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.application;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Rate {
    private String orgNo;
    private String prdId;
    private String ocLimitDate;
    private String rateType;
    private BigDecimal constantRate;
    private BigDecimal floatingRate;
    private String refundType;
}
