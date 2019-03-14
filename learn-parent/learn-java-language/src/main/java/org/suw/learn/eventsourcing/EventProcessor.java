/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.eventsourcing;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EventProcessor {
    List<DomainEvent> log = new ArrayList<DomainEvent>();
    private boolean active;

    public void process(DomainEvent event) {
        active = true;
        event.process();
        active = false;
        log.add(event);
    }

}
