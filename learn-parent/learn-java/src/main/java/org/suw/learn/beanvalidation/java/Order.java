/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@BusinessEntity(message = "test.beanvalidation.Order")
public class Order { 
    // 必须不为 null, 大小是 10 
    @NotNull 
    @Size(min = 10, max = 10) 
    private String orderId; 
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
    @Status
    private String status; 
    // 必须不为 null 
    @NotNull 
    private Date createDate; 
    // 嵌套验证
    @Valid 
    private Product product;
}