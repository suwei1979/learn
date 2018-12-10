/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.precredit;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.Data;

/**
 * Created by li10 on 15-6-12.
 */
@Data
public class PreLimit {
    private BigDecimal preAmount;
    private Currency preCurrency;
    private String preLimitType;
}
