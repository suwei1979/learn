package org.suw.learn.domain.order.service;

import org.suw.learn.domain.model.Order;

public interface OrderStateAware  {
	void orderCreated(Order order);
}
