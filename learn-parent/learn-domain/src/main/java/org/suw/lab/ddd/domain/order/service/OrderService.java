/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.order.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.suw.lab.ddd.domain.model.Item;
import org.suw.lab.ddd.domain.model.Order;

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