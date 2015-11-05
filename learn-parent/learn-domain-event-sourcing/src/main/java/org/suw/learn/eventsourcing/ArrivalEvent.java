package org.suw.learn.eventsourcing;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArrivalEvent extends DomainEvent {

	@Setter(value = AccessLevel.NONE)
	private Port port;
	
	@Setter(value = AccessLevel.NONE)
	private Ship ship;

	public ArrivalEvent(Date time, Port sfo, Ship kr) {
		super(time);
		this.port = sfo;
		this.ship = kr;
	}

	@Override
	public void process() {
		ship.handleArrival(this);
		
	}

}
