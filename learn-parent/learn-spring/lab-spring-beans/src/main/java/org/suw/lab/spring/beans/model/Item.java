/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.model;

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
