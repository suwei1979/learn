/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

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
