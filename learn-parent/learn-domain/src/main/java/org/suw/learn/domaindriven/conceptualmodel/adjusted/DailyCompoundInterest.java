package org.suw.learn.domaindriven.conceptualmodel.adjusted;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DailyCompoundInterest extends AccrualSchedule {
	private BigDecimal rate;
	
}
