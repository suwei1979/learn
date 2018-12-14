/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartureEvent extends DomainEvent {
    @Setter(value = AccessLevel.NONE)
    private Port port;

    @Setter(value = AccessLevel.NONE)
    private Ship ship;

    public DepartureEvent(Date time, Port aPort, Ship aShip) {
        super(time);
        this.port = aPort;
        this.ship = aShip;
    }

    @Override
    public void process() {
        ship.handleDeparture(this);
    }

}
