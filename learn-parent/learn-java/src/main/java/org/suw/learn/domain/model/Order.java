/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import java.util.HashSet;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotBlank;
import org.suw.learn.validation.constraints.MasterDataEntity;
import org.suw.learn.validation.constraints.ZipCode;

@MasterDataEntity
public class Order {
    @NotBlank(groups = {UpdateEvent.class}, message = "orderID不能为空！")
    private String orderId;
    @Valid
    private HashSet<Item> orderItems;
    @ZipCode(countryCode = "CN", message = "customerID必须为ZipCode", groups = {Default.class})
    private String customerId;
    @Min(0)
    private int amount;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public HashSet<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(HashSet<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public void addItem(Item item) {
        if (this.orderItems == null) {
            orderItems = new HashSet<Item>();
        }
        orderItems.add(item);
    }
}
