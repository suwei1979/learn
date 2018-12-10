/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class Tester {
	Ship kr;
	Port sfo, la, yyv;
	Cargo refact;
	Calendar calendar = Calendar.getInstance();
	EventProcessor eProc;

	@Before
	public void setUp() {
		eProc = new EventProcessor();
		refact = new Cargo("Refactoring");
		kr = new Ship("King Roy");
		sfo = new Port("San Francisco", Country.US);
		la = new Port("Los Angeles", Country.US);
		yyv = new Port("Vancouver", Country.CANADA);
	}
	
	@Test
	public void arrivalSetsShipLocation() {
		calendar.set(2005, 11, 1);
		
		ArrivalEvent event = new ArrivalEvent(calendar.getTime(), sfo, kr);
		eProc.process(event);
		 assertThat(sfo).isEqualTo(kr.getPort());
	}
	
	public void departurePutsShipOutToSea() {
		calendar.set(2005, 10, 1);
		eProc.process(new ArrivalEvent(calendar.getTime(), la, kr));
		calendar.set(2005, 11, 1);
		eProc.process(new ArrivalEvent(calendar.getTime(), sfo, kr));
		calendar.set(2005, 11, 1);
		eProc.process(new DepartureEvent(calendar.getTime(), sfo, kr));
		assertThat(Port.AT_SEA).isEqualTo(kr.getPort());
	}
	
	public void visitingCanadaMarksCargo() {
		calendar.set(2015, 11, 1);
		eProc.process(new LoadEvent(calendar.getTime(), refact, kr));
		calendar.set(2015, 11, 2);
		eProc.process(new ArrivalEvent(calendar.getTime(), yyv, kr));
		calendar.set(2015, 11, 3);
		eProc.process(new DepartureEvent(calendar.getTime(), yyv, kr));
		calendar.set(2015, 11, 4);
		eProc.process(new ArrivalEvent(calendar.getTime(), sfo, kr));
		calendar.set(2015, 11, 5);
		eProc.process(new UnloadEvent(calendar.getTime(), refact, kr));
	}
}
