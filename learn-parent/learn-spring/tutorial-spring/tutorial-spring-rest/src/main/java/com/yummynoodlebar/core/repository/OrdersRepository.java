/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.yummynoodlebar.core.repository;

import java.util.List;
import java.util.UUID;

import com.yummynoodlebar.core.domain.Order;

//TODO, make this event based again, with persistence integration events.
public interface OrdersRepository {

    Order save(Order order);

    void delete(UUID key);

    Order findById(UUID key);

    List<Order> findAll();
}
