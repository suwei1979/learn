/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.service.impl;

import org.springframework.stereotype.Service;
import org.suw.lab.ddd.domain.service.CreditCardProcessor;

@Service("creditCardProcessor")
public class DefaultCreditCardProcessor implements CreditCardProcessor {

    /* (non-Javadoc)
     * @see org.suw.learn.CreditCardProcessor#test()
     */
    @Override
    public void test() {
        System.out.println("credit card processor proceed!");

    }

}
