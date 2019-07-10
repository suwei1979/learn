/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.order.service.impl;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.suw.lab.ddd.domain.model.Item;
import org.suw.lab.ddd.domain.model.Order;
import org.suw.lab.ddd.domain.order.service.OrderService;
import org.suw.lab.ddd.domain.order.service.OrderStateAware;
import org.suw.lab.ddd.domain.service.CreditCardProcessor;
import org.suw.lab.ddd.domain.service.EntityManager;
import org.suw.lab.ddd.domain.service.impl.OtherService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    OrderStateAware orderState = new OtherService();
    SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
    ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
    Validator validator;
    @Autowired
    private EntityManager<Order> orderManager;
    @NotNull
    @Autowired
    private CreditCardProcessor creditCardProcessor;

    @Valid
    @Autowired
    public OrderServiceImpl(@NotNull CreditCardProcessor creditCardProcessor) {

    }

    @Override
    public Order placeOrder(String customerCode, Item item, int quantity) {
        System.out.println("---------------------placeOrder begin");
        final Order order = new Order("");
        order.setCustomerId(customerCode);
        order.addItem(item);
        orderManager.insert(order);
        //        //OrderBackup created
        //        threadPool.initialize();
        //        threadPool.execute(new Runnable() {
        //            public void run() {
        orderState.orderCreated(order);
        //            }
        //        });
        System.out.println("---------------------placeOrder end");
        return order;
    }

}
