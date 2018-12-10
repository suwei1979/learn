/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author suwei
 */
public class Order {
    private final String orderId;
    private Number price;
    private Set<Item> items = new LinkedHashSet<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
