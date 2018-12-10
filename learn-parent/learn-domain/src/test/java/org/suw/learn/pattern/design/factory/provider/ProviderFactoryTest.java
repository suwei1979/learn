/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.provider;

import org.suw.learn.pattern.design.factory.service.Sender;

public class ProviderFactoryTest {
    public static void main(String args[]) {
        SenderProvider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
