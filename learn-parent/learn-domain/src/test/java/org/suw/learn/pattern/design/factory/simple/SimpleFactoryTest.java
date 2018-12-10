/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.simple;

import org.suw.learn.pattern.design.factory.simple.MessageSender;
import org.suw.learn.pattern.design.factory.simple.SampleFactory;

public class SimpleFactoryTest {
    public static final int SENDER_TYPE_MAIL = 1;
    public static final int SENDER_TYPE_SMS = 2;
    public static void main(String[] args) {
        MessageSender sender = SampleFactory.create(SENDER_TYPE_MAIL);
        sender.send();
        sender = SampleFactory.create(SENDER_TYPE_SMS);
        sender.send();
        sender = SampleFactory.produceMailSender();
        sender.send();
        sender = SampleFactory.produceSmsSender();
        sender.send();
    }
}
