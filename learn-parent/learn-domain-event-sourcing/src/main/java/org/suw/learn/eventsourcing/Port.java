/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import lombok.Data;

@Data
public class Port {

	public static final Port AT_SEA = null;

	private Country country;

	private String name;
	public Port(String name, Country country) {
		this.name = name;
		this.country = country;
	}
	public void handleArrival(ArrivalEvent arrivalEvent) {
		arrivalEvent.getShip().setPort(this);
		Registry.customsNotificationGateway().notify(arrivalEvent.occurred, arrivalEvent.getShip(), arrivalEvent.getPort());

	}


	public Country getCountry() {
		return country;
	}
}
