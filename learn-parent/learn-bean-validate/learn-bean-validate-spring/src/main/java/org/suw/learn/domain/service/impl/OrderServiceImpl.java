package org.suw.learn.domain.service.impl;

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
import org.suw.learn.domain.service.BizEntityManager;
import org.suw.learn.domain.service.CreditCardProcessor;
import org.suw.learn.domain.service.OrderService;
import org.suw.learn.domain.service.OrderStateAware;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private BizEntityManager<Order> orderManager;
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
        System.out.println("placeOrder begin");
        Order order = new Order("OD00001");
        order.setCustomerId(customerCode);
        order.addItem(item);
        threadPool.initialize();
        threadPool.execute(new Runnable() {

            public void run() {
                orderState.orderCreated();
            }
        });
        System.out.println("placeOrder end");
        return order;
    }

    @Override
    public Order insert(Order toInsert) {
        System.out.println("insert order begin");
        
        System.out.println("insert order end");
//        validator.validate(toInsert, Create.class);
        return null;
    }

}
