/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

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

    public static Ship find(int shipCode) {
        // TODO Auto-generated provider stub
        return null;
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

    public void handleLoad(LoadEvent loadEvent) {
        // TODO Auto-generated provider stub

    }

}
