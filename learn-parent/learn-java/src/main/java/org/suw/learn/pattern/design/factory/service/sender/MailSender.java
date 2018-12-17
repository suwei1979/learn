/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.service.sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("MailSender.send");
    }
}
