/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
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
