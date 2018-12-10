/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Cargo {
	@Setter(value = AccessLevel.NONE)
	private boolean hasBeenInCanada = false;
	private Port port;
	private Ship ship;
	
	public Cargo(String name) {
		// TODO Auto-generated constructor stub
	}

	public void handleArrival(ArrivalEvent arrivalEvent) {
		if (Country.CANADA == arrivalEvent.getPort().getCountry())
			this.hasBeenInCanada = true;
	}

	public Cargo find(String cargoCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleLoad(LoadEvent loadEvent) {
		loadEvent.setPriorPort(this.port);
		this.port = null;
		this.ship = loadEvent.getShip();
		ship.handleLoad(loadEvent);
		
	}

}
