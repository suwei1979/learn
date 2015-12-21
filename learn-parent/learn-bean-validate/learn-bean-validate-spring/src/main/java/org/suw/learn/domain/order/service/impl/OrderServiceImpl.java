package org.suw.learn.domain.order.service.impl;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.suw.learn.domain.model.Create;
import org.suw.learn.domain.model.Item;
import org.suw.learn.domain.model.Order;
import org.suw.learn.domain.order.service.OrderService;
import org.suw.learn.domain.order.service.OrderStateAware;
import org.suw.learn.domain.service.EntityManager;
import org.suw.learn.domain.service.CreditCardProcessor;
import org.suw.learn.domain.service.impl.OtherService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private EntityManager<Order> orderManager;
    OrderStateAware orderState = new OtherService();
    @NotNull
    @Autowired
    private CreditCardProcessor creditCardProcessor;
    SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
    ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
    Validator validator;

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
//        //Order created
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
