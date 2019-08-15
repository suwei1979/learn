/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.conceptualmodel.adjusted;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DailyCompoundInterest extends AccrualSchedule {
    private BigDecimal rate;

}
