/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

import com.yummynoodlebar.core.events.RequestReadEvent;

public class RequestOrderDetailsEvent extends RequestReadEvent {
    private UUID key;

    public RequestOrderDetailsEvent(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }
}
