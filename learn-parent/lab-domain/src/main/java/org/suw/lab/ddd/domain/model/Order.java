/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import java.util.Date;
import java.util.HashSet;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.suw.lab.ddd.validation.constraints.MasterDataEntity;
import org.suw.lab.ddd.validation.constraints.ZipCode;

import lombok.Data;

@MasterDataEntity
@Data
public class Order {
    @NotNull
    @NotBlank(groups = {UpdateEvent.class}, message = "orderID不能为空！")
    @Size(min = 10, max = 10)
    private String orderId;

    @Valid
    private HashSet<Item> orderItems;

    @ZipCode(countryCode = "CN", message = "customerID必须为ZipCode", groups = {Default.class})
    private String customerId;

    @Min(0)
    private int amount;

    // 必须不为空
    @NotEmpty
    private String customer;

    // 必须是一个电子信箱地址
    @Email
    private String email;

    // 必须不为空
    @NotEmpty
    private String address;

    // 必须不为 null, 必须是下面四个字符串'created', 'paid', 'shipped', 'closed'其中之一
    // @Status 是一个定制化的 contraint
    @NotNull
    private String status;
    // 必须不为 null
    @NotNull
    private Date createDate;
    // 嵌套验证
    @Valid
    private Product product;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void addItem(Item item) {
        if (this.orderItems == null) {
            orderItems = new HashSet<Item>();
        }
        orderItems.add(item);
    }
}
