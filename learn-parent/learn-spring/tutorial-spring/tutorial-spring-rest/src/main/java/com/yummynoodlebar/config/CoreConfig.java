/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.config;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yummynoodlebar.core.domain.Order;
import com.yummynoodlebar.core.repository.OrdersMemoryRepository;
import com.yummynoodlebar.core.repository.OrdersRepository;
import com.yummynoodlebar.core.services.OrderEventHandler;
import com.yummynoodlebar.core.services.OrderService;

@Configuration
public class CoreConfig {

    @Bean
    public OrderService createService(OrdersRepository repo) {
        return new OrderEventHandler(repo);
    }

    @Bean
    public OrdersRepository createRepo() {
        return new OrdersMemoryRepository(new HashMap<UUID, Order>());
    }

}
