/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

/**
 * @author suwei
 */
public class OrderFactory implements EntityFactory<Order> {

    /*
     * (non-Javadoc)
     *
     * @see EntityFactory#create()
     */
    @Override
    public Order create() {

        return new Order("testOrder");
    }

    /*
     * (non-Javadoc)
     *
     * @see EntityFactory#entityName()
     */
    @Override
    public String entityName() {
        // TODO Auto-generated provider stub
        return Order.class.getSimpleName().toLowerCase();
    }

}
