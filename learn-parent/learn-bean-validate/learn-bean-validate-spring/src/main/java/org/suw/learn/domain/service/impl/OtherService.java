package org.suw.learn.domain.service.impl;

import org.suw.learn.domain.model.Order;
import org.suw.learn.domain.order.service.OrderStateAware;


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
