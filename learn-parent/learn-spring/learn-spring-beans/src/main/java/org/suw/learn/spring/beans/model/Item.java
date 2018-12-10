/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

import lombok.Data;

/**
 * @author suwei
 */
@Data
public class Item {

    private final String name;
    private Number price;
    private int quantity;

//    public Item(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Number getPrice() {
//        return price;
//    }
//
//    public void setPrice(Number price) {
//        this.price = price;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
}
