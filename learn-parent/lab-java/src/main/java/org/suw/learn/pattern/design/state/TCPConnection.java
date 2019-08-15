/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.state;

class TCPConnection {
    private TCPState state;

    public TCPConnection() {
        state = new TCPClosed();
    }

    public void ActiveOpen() {
        state.activeOpen(this);

    }

    public void PassiveOpen() {
        state.passiveOpen(this);
    }

    public void Send() {
        state.send(this);
    }

    public void Acknowledge() {
        state.acknowledge(this);
    }

    public void Synchronize() {
        state.synchronize(this);
    }

    public void ProcessOctet(TCPOctetStream stream) {

    }

    public void ChangeState(TCPState newState) {
        this.state = newState;
    }
}
