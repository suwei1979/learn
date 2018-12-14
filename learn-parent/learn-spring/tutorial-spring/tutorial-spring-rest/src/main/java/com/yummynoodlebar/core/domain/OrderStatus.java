/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.yummynoodlebar.core.domain;

import java.util.Date;

import com.yummynoodlebar.core.events.orders.OrderStatusDetails;

public class OrderStatus {

    private Date statusDate;
    private String status;

    public OrderStatus(final Date date, final String status) {
        this.status = status;
        this.statusDate = date;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public String getStatus() {
        return status;
    }

    public OrderStatusDetails toStatusDetails() {
        return new OrderStatusDetails(statusDate, status);
    }
}
