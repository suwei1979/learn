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
