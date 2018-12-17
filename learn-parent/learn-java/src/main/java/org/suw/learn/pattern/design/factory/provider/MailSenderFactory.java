/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.provider;

import org.suw.learn.pattern.design.factory.service.sender.MailSender;
import org.suw.learn.pattern.design.factory.service.sender.Sender;

public class MailSenderFactory implements SenderProvider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
