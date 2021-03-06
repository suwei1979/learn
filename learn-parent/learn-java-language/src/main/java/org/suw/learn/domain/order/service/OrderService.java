/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.order.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.suw.learn.domain.model.Item;
import org.suw.learn.domain.model.Order;

@Validated
public interface OrderService {
    /**
     * @param customerCode
     * @param item
     * @param quantity
     *
     * @return
     */
    @NotNull
    public Order placeOrder(
            //test
            @NotNull
            @Size(min = 3, max = 20)
                    String customerCode,

            @NotNull
            @Valid
                    Item item,

            @Min(1)
                    int quantity);
}