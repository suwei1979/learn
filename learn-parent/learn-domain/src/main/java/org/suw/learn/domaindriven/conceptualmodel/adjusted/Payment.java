package org.suw.learn.domaindriven.conceptualmodel.adjusted;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Payment {
	private Date date;
	private BigDecimal amount;
	private String ledgerName;
}
