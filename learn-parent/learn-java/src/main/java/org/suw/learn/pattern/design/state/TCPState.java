/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.state;

interface TCPState {
    void transmit(TCPConnection context, TCPOctetStream stream);

    void activeOpen(TCPConnection context);

    void passiveOpen(TCPConnection context);

    void close(TCPConnection context);

    void open(TCPConnection context);

    void synchronize(TCPConnection context);

    void acknowledge(TCPConnection context);

    void send(TCPConnection context);

    default void changeState(TCPConnection context, TCPState state) {
        context.ChangeState(state);
    }
}