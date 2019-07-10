/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.conceptualmodel.adjusted;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class Asset {
    private BigDecimal principalAmount;
    private Date lastAccuralCalculationDate;
    private Set<AccrualSchedule> schedules;
    private Set<IncomeAccrual> incomeAccruals;
    private Set<Payment> payments;

    public BigDecimal calculateAccrualsThrough(Date date) {
        return null;
    }
}
