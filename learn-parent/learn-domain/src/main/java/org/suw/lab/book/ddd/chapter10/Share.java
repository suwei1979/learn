/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.chapter10;

import lombok.Data;

@Data
public class Share {
    private Company owner;
    private double amount;

    public Share(Company owner, double amount) {
        super();
        this.owner = owner;
        this.amount = amount;
    }

    public Company getOwner() {
        return owner;
    }

    public double getAmount() {
        return amount;
    }
}
