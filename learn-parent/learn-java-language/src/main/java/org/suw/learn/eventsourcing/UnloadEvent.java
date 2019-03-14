/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import java.util.Date;

public class UnloadEvent extends DomainEvent {

    public UnloadEvent(Date time, Cargo refact, Ship kr) {
        super(time);
    }

    @Override
    public void process() {
        // TODO Auto-generated provider stub

    }

}
