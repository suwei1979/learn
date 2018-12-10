/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domaindriven.chapter10;

public class Facility {
	private SharePie shares;
	
	public SharePie calculateDrawDownDefaultDistribution(double drawDownAmount) {
		return shares.prorated(drawDownAmount);
	}
}
