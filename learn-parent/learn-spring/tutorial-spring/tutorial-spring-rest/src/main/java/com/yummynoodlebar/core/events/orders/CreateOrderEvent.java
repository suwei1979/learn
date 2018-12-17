/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import com.yummynoodlebar.core.events.CreateEvent;

public class CreateOrderEvent extends CreateEvent {
    private OrderDetails details;

    public CreateOrderEvent(OrderDetails details) {
        this.details = details;
    }

    public OrderDetails getDetails() {
        return details;
    }
}
