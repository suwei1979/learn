/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

import java.util.Date;

public abstract class DomainEvent {
    Date recorded, occurred;

    protected DomainEvent(Date occurred) {
        this.occurred = occurred;
        this.recorded = new Date(System.currentTimeMillis());
    }

    public abstract void process();
}
