/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.service.sender;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("SmsSender.send");
    }
}
