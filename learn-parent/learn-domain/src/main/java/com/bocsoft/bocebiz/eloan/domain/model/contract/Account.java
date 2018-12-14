/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.contract;

import java.util.Currency;

import lombok.Data;

@Data
public class Account {
    private String accountNo;
    private Currency currency;
    ////还款账户
    // 签合同时选的就是还款账户
    //修改账户时，woego修改的是还款账户
    //           pos贷修改的是提还款账户
    //所以也许会有 根据产品类型，对提还款账户的约束等（如提还款同一个账户）
}
