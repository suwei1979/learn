/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.composite;

import java.util.ArrayList;
import java.util.Currency;

public abstract class Equipment {
    private String name;

    protected Equipment() {

    }

    public String getName() {
        return name;
    }

    public abstract Watt power();

    public abstract Currency netPrice();

    public abstract Currency discountPrice();

    public abstract void add(Equipment part);

    public abstract void remove(Equipment part);

    public abstract ArrayList<Equipment> iterator();
}
