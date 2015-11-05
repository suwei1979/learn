package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

import com.yummynoodlebar.core.events.UpdateEvent;

public class UpdateOrderEvent extends UpdateEvent {

  private UUID key;
  private OrderDetails orderDetails;

  public UpdateOrderEvent(UUID key, OrderDetails orderDetails) {
    this.key = key;
    this.orderDetails = orderDetails;
  }

  public UUID getKey() {
    return key;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }
}
