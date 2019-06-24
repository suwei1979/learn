/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

import com.yummynoodlebar.core.events.UpdatedEvent;

public class OrderUpdatedEvent extends UpdatedEvent {

    private UUID key;
    private OrderDetails orderDetails;

    public OrderUpdatedEvent(UUID key, OrderDetails orderDetails) {
        this.key = key;
        this.orderDetails = orderDetails;
    }

    public UUID getKey() {
        return key;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}
