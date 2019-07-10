/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

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
