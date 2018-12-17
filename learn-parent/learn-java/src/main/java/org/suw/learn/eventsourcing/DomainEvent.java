/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import java.util.Date;

public abstract class DomainEvent {
    Date recorded, occurred;

    protected DomainEvent(Date occurred) {
        this.occurred = occurred;
        this.recorded = new Date(System.currentTimeMillis());
    }

    public abstract void process();
}
