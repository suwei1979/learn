/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.simple;

import org.suw.learn.pattern.design.factory.service.sender.MailSender;
import org.suw.learn.pattern.design.factory.service.sender.Sender;
import org.suw.learn.pattern.design.factory.service.sender.SenderType;
import org.suw.learn.pattern.design.factory.service.sender.SmsSender;

public class SimpleSenderFactory {
    public static Sender create(SenderType type) {
        if (SenderType.MAIL == type) {
            return new MailSender();
        } else if (SenderType.SMS == type) {
            return new SmsSender();
        } else {
            System.out.println("SimpleSenderFactory.create can't find the type " + type + ", return null");
            return null;
        }
    }

    public static Sender createMailSender() {
        return create(SenderType.MAIL);
    }

    public static Sender createSmsSender() {
        return create(SenderType.SMS);
    }
}
