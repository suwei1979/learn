/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
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
