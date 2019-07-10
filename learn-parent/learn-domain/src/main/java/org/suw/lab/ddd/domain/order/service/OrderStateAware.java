/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.order.service;

import org.suw.lab.ddd.domain.model.Order;

public interface OrderStateAware {
    void orderCreated(Order order);
}
