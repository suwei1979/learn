/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

import com.yummynoodlebar.core.events.UpdateEvent;

public class SetPaymentEvent extends UpdateEvent {

    private UUID key;
    private OrderDetails orderDetails;

    public SetPaymentEvent(UUID key, OrderDetails orderDetails) {
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
