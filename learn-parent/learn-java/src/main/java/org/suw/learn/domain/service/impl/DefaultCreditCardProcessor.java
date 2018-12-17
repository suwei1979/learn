/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.service.impl;

import org.springframework.stereotype.Service;
import org.suw.learn.domain.service.CreditCardProcessor;

@Service("creditCardProcessor")
public class DefaultCreditCardProcessor implements CreditCardProcessor {

    /* (non-Javadoc)
     * @see org.suw.learn.domain.service.CreditCardProcessor#test()
     */
    @Override
    public void test() {
        System.out.println("credit card processor proceed!");

    }

}
