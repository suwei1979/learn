package org.suw.learn.domaindriven.conceptualmodel.adjusted;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MonthlyFee extends AccrualSchedule {
	private BigDecimal amount;
	private int dayOfMonthDue;
}
