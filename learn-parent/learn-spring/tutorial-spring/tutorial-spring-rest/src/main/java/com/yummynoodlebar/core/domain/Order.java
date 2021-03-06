/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.yummynoodlebar.core.events.orders.OrderDetails;

public class Order {

    private final Date dateTimeOfSubmission;
    private final UUID key;
    private Map<String, Integer> orderItems;
    private Customer customer;

    private OrderStatus status;
    private List<OrderStatus> statusHistory;

    public Order(final Date dateTimeOfSubmission) {
        this.key = UUID.randomUUID();
        this.dateTimeOfSubmission = dateTimeOfSubmission;
        statusHistory = new ArrayList<OrderStatus>();
    }

    public static Order fromOrderDetails(OrderDetails orderDetails) {
        Order order = new Order(orderDetails.getDateTimeOfSubmission());

        BeanUtils.copyProperties(orderDetails, order);

        return order;
    }

    public void addStatus(OrderStatus newStatus) {
        statusHistory.add(newStatus);
        status = newStatus;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Date getDateTimeOfSubmission() {
        return dateTimeOfSubmission;
    }

    public UUID getKey() {
        return key;
    }

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<String, Integer> orderItems) {
        if (orderItems == null) {
            this.orderItems = Collections.emptyMap();
        } else {
            this.orderItems = Collections.unmodifiableMap(orderItems);
        }
    }

    public boolean canBeDeleted() {
        return true;
    }

    public OrderDetails toOrderDetails() {
        OrderDetails details = new OrderDetails();

        BeanUtils.copyProperties(this, details);

        return details;
    }
}
