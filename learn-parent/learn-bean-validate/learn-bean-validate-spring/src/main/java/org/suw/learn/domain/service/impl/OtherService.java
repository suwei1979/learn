package org.suw.learn.domain.service.impl;

import org.suw.learn.domain.service.OrderStateAware;

public class OtherService implements OrderStateAware {

	@Override
	public void orderCreated() {
		// TODO Auto-generated method stub
		System.out.println("orderCreate begin" + System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("orderCreate end  " + System.currentTimeMillis());

	}

}
