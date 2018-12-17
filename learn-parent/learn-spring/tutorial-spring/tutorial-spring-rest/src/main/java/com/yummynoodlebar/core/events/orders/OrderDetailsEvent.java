/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

import com.yummynoodlebar.core.events.ReadEvent;

public class OrderDetailsEvent extends ReadEvent {
    private UUID key;
    private OrderDetails orderDetails;

    private OrderDetailsEvent(UUID key) {
        this.key = key;
    }

    public OrderDetailsEvent(UUID key, OrderDetails orderDetails) {
        this.key = key;
        this.orderDetails = orderDetails;
    }

    public static OrderDetailsEvent notFound(UUID key) {
        OrderDetailsEvent ev = new OrderDetailsEvent(key);
        ev.entityFound = false;
        return ev;
    }

    public UUID getKey() {
        return key;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}
