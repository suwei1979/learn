/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.order.service;

import org.suw.learn.domain.model.Order;

public interface OrderStateAware {
    void orderCreated(Order order);
}
