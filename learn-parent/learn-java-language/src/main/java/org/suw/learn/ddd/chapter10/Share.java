/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.chapter10;

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
