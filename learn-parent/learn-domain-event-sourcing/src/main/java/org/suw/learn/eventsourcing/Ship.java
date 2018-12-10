/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Ship {
	@Setter(value = AccessLevel.NONE)
	private String name;

	private Port port;
	
	@Setter(value = AccessLevel.NONE)
	private List<Cargo> cargoes;

	public Ship(String aName) {
		this.name = aName;
	}

	public void handleDeparture(DepartureEvent departureEvent) {
		this.port = Port.AT_SEA;
	}

	public void handleArrival(ArrivalEvent arrivalEvent) {
		this.port = arrivalEvent.getPort();
		for (Cargo cargo : cargoes) {
			cargo.handleArrival(arrivalEvent);
		}
	}

	public static Ship find(int shipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleLoad(LoadEvent loadEvent) {
		// TODO Auto-generated method stub
		
	}

}
