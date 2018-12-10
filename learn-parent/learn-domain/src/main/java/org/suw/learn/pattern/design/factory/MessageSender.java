/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory;

import lombok.Data;

public interface MessageSender {
    void send();
}