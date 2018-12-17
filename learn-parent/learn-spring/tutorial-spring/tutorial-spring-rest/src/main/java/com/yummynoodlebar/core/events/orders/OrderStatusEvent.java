/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

import com.yummynoodlebar.core.events.ReadEvent;

public class OrderStatusEvent extends ReadEvent {
    private UUID key;
    private OrderStatusDetails orderStatus;

    private OrderStatusEvent(UUID key) {
        this.key = key;
    }

    public OrderStatusEvent(UUID key, OrderStatusDetails orderStatus) {
        this.key = key;
        this.orderStatus = orderStatus;
    }

    public static OrderStatusEvent notFound(UUID key) {
        OrderStatusEvent ev = new OrderStatusEvent(key);
        ev.entityFound = false;
        return ev;
    }

    public UUID getKey() {
        return key;
    }

    public OrderStatusDetails getOrderStatus() {
        return orderStatus;
    }
}
