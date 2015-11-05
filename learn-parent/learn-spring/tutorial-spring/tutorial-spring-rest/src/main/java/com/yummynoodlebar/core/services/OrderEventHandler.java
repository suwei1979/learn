package com.yummynoodlebar.core.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yummynoodlebar.core.domain.Order;
import com.yummynoodlebar.core.domain.OrderStatus;
import com.yummynoodlebar.core.events.orders.AllOrdersEvent;
import com.yummynoodlebar.core.events.orders.CreateOrderEvent;
import com.yummynoodlebar.core.events.orders.DeleteOrderEvent;
import com.yummynoodlebar.core.events.orders.OrderCreatedEvent;
import com.yummynoodlebar.core.events.orders.OrderDeletedEvent;
import com.yummynoodlebar.core.events.orders.OrderDetails;
import com.yummynoodlebar.core.events.orders.OrderDetailsEvent;
import com.yummynoodlebar.core.events.orders.OrderStatusEvent;
import com.yummynoodlebar.core.events.orders.OrderUpdatedEvent;
import com.yummynoodlebar.core.events.orders.RequestAllOrdersEvent;
import com.yummynoodlebar.core.events.orders.RequestOrderDetailsEvent;
import com.yummynoodlebar.core.events.orders.RequestOrderStatusEvent;
import com.yummynoodlebar.core.events.orders.SetOrderPaymentEvent;
import com.yummynoodlebar.core.repository.OrdersRepository;

public class OrderEventHandler implements OrderService {

  private final OrdersRepository ordersRepository;

  public OrderEventHandler(final OrdersRepository ordersRepository) {
    this.ordersRepository = ordersRepository;
  }

  @Override
  public OrderCreatedEvent createOrder(CreateOrderEvent createOrderEvent) {
    Order order = Order.fromOrderDetails(createOrderEvent.getDetails());

    order.addStatus(new OrderStatus(new Date(), "Order Created"));

    order = ordersRepository.save(order);

    return new OrderCreatedEvent(order.getKey(), order.toOrderDetails());
  }

  @Override
  public AllOrdersEvent requestAllOrders(RequestAllOrdersEvent requestAllCurrentOrdersEvent) {
    List<OrderDetails> generatedDetails = new ArrayList<OrderDetails>();
    for (Order order : ordersRepository.findAll()) {
      generatedDetails.add(order.toOrderDetails());
    }
    return new AllOrdersEvent(generatedDetails);
  }

  @Override
  public OrderDetailsEvent requestOrderDetails(RequestOrderDetailsEvent requestOrderDetailsEvent) {

    Order order = ordersRepository.findById(requestOrderDetailsEvent.getKey());

    if (order == null) {
      return OrderDetailsEvent.notFound(requestOrderDetailsEvent.getKey());
    }

    return new OrderDetailsEvent(
            requestOrderDetailsEvent.getKey(),
            order.toOrderDetails());
  }

  @Override
  public OrderUpdatedEvent setOrderPayment(SetOrderPaymentEvent setOrderPaymentEvent) {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public OrderDeletedEvent deleteOrder(DeleteOrderEvent deleteOrderEvent) {

    Order order = ordersRepository.findById(deleteOrderEvent.getKey());

    if (order == null) {
      return OrderDeletedEvent.notFound(deleteOrderEvent.getKey());
    }

    OrderDetails details = order.toOrderDetails();

    //TODOCUMENT This contains some specific domain logic, not exposed to the outside world, and not part of the
    //persistence rules.

    if (!order.canBeDeleted()) {
      return OrderDeletedEvent.deletionForbidden(deleteOrderEvent.getKey(), details);
    }

    ordersRepository.delete(deleteOrderEvent.getKey());
    return new OrderDeletedEvent(deleteOrderEvent.getKey(), details);
  }

  @Override
  public OrderStatusEvent requestOrderStatus(RequestOrderStatusEvent requestOrderDetailsEvent) {
    Order order = ordersRepository.findById(requestOrderDetailsEvent.getKey());

    if (order == null) {
      return OrderStatusEvent.notFound(requestOrderDetailsEvent.getKey());
    }

    return new OrderStatusEvent(requestOrderDetailsEvent.getKey(), order.getStatus().toStatusDetails());
  }
}
