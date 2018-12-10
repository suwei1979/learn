/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.state;

class TCPClosed implements TCPState {
	static TCPState instanse = new TCPClosed();

	@Override
	public void transmit(TCPConnection context, TCPOctetStream stream) {
		// TODO Auto-generated provider stub

	}

	@Override
	public void activeOpen(TCPConnection context) {
		changeState(context, TCPEstabilished.instanse);

	}

	@Override
	public void passiveOpen(TCPConnection context) {
		changeState(context, TCPListen.instance);
	}

	@Override
	public void close(TCPConnection context) {
		// TODO Auto-generated provider stub

	}

	@Override
	public void open(TCPConnection context) {
		// TODO Auto-generated provider stub

	}

	@Override
	public void synchronize(TCPConnection context) {
		// TODO Auto-generated provider stub

	}

	@Override
	public void acknowledge(TCPConnection context) {
		// TODO Auto-generated provider stub

	}

	@Override
	public void send(TCPConnection context) {
		// TODO Auto-generated provider stub

	}

}
