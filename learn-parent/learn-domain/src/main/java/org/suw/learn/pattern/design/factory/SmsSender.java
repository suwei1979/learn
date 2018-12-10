/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory;

/**
 * @author suwei
 */
public class SmsSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("SMS Message Sender");
    }
}
