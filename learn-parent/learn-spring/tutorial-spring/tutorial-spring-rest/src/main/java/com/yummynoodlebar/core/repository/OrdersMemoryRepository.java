/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.core.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yummynoodlebar.core.domain.Order;

public class OrdersMemoryRepository implements OrdersRepository {

    private Map<UUID, Order> orders;

    public OrdersMemoryRepository(final Map<UUID, Order> orders) {
        this.orders = Collections.unmodifiableMap(orders);
    }

    @Override
    public synchronized Order save(Order order) {

        Map<UUID, Order> modifiableOrders = new HashMap<UUID, Order>(orders);
        modifiableOrders.put(order.getKey(), order);
        this.orders = Collections.unmodifiableMap(modifiableOrders);

        return order;
    }

    @Override
    public synchronized void delete(UUID key) {
        if (orders.containsKey(key)) {
            Map<UUID, Order> modifiableOrders = new HashMap<UUID, Order>(orders);
            modifiableOrders.remove(key);
            this.orders = Collections.unmodifiableMap(modifiableOrders);
        }
    }

    @Override
    public Order findById(UUID key) {
        return orders.get(key);
    }

    @Override
    public List<Order> findAll() {
        return Collections.unmodifiableList(new ArrayList<Order>(orders.values()));
    }
}
