/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.measurement;

import lombok.Data;

@Data
public class Quantity {
	private Number amount;
	private Unit units;
}
