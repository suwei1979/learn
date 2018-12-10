/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

/**
 * @author suwei
 *
 */
public class ItemFactory implements EntityFactory<Item> {

    /*
     * (non-Javadoc)
     * 
     * @see org.suw.learn.spring.beans.model.EntityFactory#create()
     */
    @Override
    public Item create() {

        return new Item("testItem");
    }

    public String entityName() {
        return Item.class.getSimpleName().toLowerCase();
    }
}
