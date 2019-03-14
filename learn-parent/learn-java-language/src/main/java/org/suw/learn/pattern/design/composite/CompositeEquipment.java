/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.composite;

import java.util.ArrayList;
import java.util.Currency;

public class CompositeEquipment extends Equipment {

    @Override
    public Watt power() {
        // TODO Auto-generated provider stub
        return null;
    }

    @Override
    public Currency netPrice() {
        ArrayList<Equipment> it = iterator();
        for (Equipment equipment : it) {
            equipment.netPrice();
        }
        // TODO Auto-generated provider stub
        return null;
    }

    @Override
    public Currency discountPrice() {
        // TODO Auto-generated provider stub
        return null;
    }

    @Override
    public void add(Equipment part) {
        // TODO Auto-generated provider stub

    }

    @Override
    public void remove(Equipment part) {
        // TODO Auto-generated provider stub

    }

    @Override
    public ArrayList<Equipment> iterator() {
        // TODO Auto-generated provider stub
        return null;
    }

}
