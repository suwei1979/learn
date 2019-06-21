/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.lab.spring.beans.model;

/**
 * @author suwei
 */
public class ItemFactory implements EntityFactory<Item> {

    /*
     * (non-Javadoc)
     *
     * @see EntityFactory#create()
     */
    @Override
    public Item create() {

        return new Item("testItem");
    }

    public String entityName() {
        return Item.class.getSimpleName().toLowerCase();
    }
}
