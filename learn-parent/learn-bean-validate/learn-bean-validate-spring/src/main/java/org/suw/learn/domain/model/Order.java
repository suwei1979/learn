package org.suw.learn.domain.model;

import java.util.HashSet;


public class Order {
	private String orderId;
	private HashSet<Item> orderItems;
	private String customerId;
	private int amount;
	
	public Order(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderId() {
		return orderId;
	}
	public HashSet<Item> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(HashSet<Item> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addItem(Item item) {
		if (this.orderItems == null) {
			orderItems = new HashSet<Item>();
		}
		orderItems.add(item);
	}
}
