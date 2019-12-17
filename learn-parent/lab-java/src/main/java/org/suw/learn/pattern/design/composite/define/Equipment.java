/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.composite.define;

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
