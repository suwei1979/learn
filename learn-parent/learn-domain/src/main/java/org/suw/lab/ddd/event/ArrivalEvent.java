/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

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

    public Port getPort() {
        return port;
    }

    @Override
    public void process() {
        ship.handleArrival(this);

    }

}
