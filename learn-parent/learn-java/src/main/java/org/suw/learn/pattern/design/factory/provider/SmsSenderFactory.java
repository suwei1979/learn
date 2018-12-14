/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.provider;

import org.suw.learn.pattern.design.factory.service.sender.Sender;
import org.suw.learn.pattern.design.factory.service.sender.SmsSender;

public class SmsSenderFactory implements SenderProvider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
