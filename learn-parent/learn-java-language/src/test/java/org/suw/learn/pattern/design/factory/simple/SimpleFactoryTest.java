/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.simple;

import org.suw.learn.pattern.design.factory.service.sender.Sender;
import org.suw.learn.pattern.design.factory.service.sender.SenderType;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        Sender sender = SimpleSenderFactory.create(SenderType.MAIL);
        sender.send();
        sender = SimpleSenderFactory.create(SenderType.SMS);
        sender.send();
        sender = SimpleSenderFactory.createMailSender();
        sender.send();
        sender = SimpleSenderFactory.createSmsSender();
        sender.send();
    }
}
