/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory;

public class MailSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("Mail Sender");
    }
}
