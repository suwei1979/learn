/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory;

public class SampleFactory {
    public static MessageSender create(int which) {
        if (which == 1) {
            return new MailSender();
        }
        else if (which == 2) {
            return new SmsSender();
        }
        return null;
    }
}
