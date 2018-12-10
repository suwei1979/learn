/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domaindriven.conceptualmodel.adjusted;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DailyCompoundInterest extends AccrualSchedule {
	private BigDecimal rate;
	
}
