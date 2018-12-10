/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans.model;

/**
 * @author suwei
 *
 */
public class OrderFactory implements EntityFactory<Order> {

    /*
     * (non-Javadoc)
     * 
     * @see org.suw.learn.spring.beans.model.EntityFactory#create()
     */
    @Override
    public Order create() {

        return new Order("testOrder");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.suw.learn.spring.beans.model.EntityFactory#entityName()
     */
    @Override
    public String entityName() {
        // TODO Auto-generated method stub
        return Order.class.getSimpleName().toLowerCase();
    }

}
