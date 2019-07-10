/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service.impl;

import org.suw.lab.ddd.domain.model.Order;
import org.suw.lab.ddd.domain.order.service.OrderStateAware;

public class OtherService implements OrderStateAware {
    @Override
    public void orderCreated(Order order) {
        System.out.println("---------------------orderCreated begin" + System.currentTimeMillis());
        //		try {
        //			Thread.sleep(3000);
        //		} catch (InterruptedException e) {
        //			e.printStackTrace();
        //		}
        System.out.println("---------------------orderCreated end  " + System.currentTimeMillis());

    }

}
