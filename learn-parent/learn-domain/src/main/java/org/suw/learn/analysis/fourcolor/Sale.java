/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.analysis.fourcolor;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author suwei
 * @archetype moment-interval
 */
@Data
public class Sale {

	public BigDecimal calcTotal() {
		return BigDecimal.valueOf(0);
	}
	
	private int number;
	private Date date;
}
