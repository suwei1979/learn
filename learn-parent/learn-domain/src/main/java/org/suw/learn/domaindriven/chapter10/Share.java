/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domaindriven.chapter10;

import lombok.Data;

@Data
public class Share {
	private Company owner;
	private double amount;

	public Share(Company owner, double amount) {
		super();
		this.owner = owner;
		this.amount = amount;
	}
	
	
}
