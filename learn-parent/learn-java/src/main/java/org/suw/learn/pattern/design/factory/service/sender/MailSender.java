/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.service.sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("MailSender.send");
    }
}
