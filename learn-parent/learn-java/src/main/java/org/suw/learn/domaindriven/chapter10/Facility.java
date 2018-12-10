/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domaindriven.chapter10;

public class Facility {
	private SharePie shares;
	
	public SharePie calculateDrawDownDefaultDistribution(double drawDownAmount) {
		return shares.prorated(drawDownAmount);
	}
}
