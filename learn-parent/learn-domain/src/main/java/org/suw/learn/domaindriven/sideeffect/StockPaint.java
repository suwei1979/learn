/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domaindriven.sideeffect;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StockPaint extends Paint {
	
	public StockPaint(double volume, PigmentColor color) {
		this.volume = volume;
		this.color = color;
	}

}
