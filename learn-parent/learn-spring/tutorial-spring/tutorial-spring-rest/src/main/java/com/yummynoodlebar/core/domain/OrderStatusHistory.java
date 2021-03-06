/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.domain;

import java.util.Set;

public class OrderStatusHistory {

    private final Set<OrderStatus> orderStatuses;

    public OrderStatusHistory(final Set<OrderStatus> orderStatuses) {
        this.orderStatuses = orderStatuses;
    }

    public void addStatus(final OrderStatus orderStatus) {
        this.orderStatuses.add(orderStatus);
    }
}
