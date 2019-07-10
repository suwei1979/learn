/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoadEvent extends DomainEvent {

    @Getter(value = AccessLevel.NONE)
    private int shipCode;

    @Getter(value = AccessLevel.NONE)
    private String cargoCode;
    private Port priorPort;

    private LoadEvent(Date occurred, int shipCode, String cargoCode) {
        super(occurred);
        this.shipCode = shipCode;
        this.cargoCode = cargoCode;
    }

    protected LoadEvent(Date occurred, Cargo cargo, Ship ship) {
        super(occurred);
        // TODO Auto-generated constructor stub
    }

    public Port getPriorPort() {
        return priorPort;
    }

    public void setPriorPort(Port priorPort) {
        this.priorPort = priorPort;
    }

    @Override
    public void process() {
        getCargo().handleLoad(this);

    }

    public Ship getShip() {
        return Ship.find(shipCode);
    }

    public Cargo getCargo() {
        return getCargo().find(cargoCode);
    }
}
