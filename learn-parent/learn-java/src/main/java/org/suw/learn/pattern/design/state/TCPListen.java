/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.state;

class TCPListen implements TCPState {

	static TCPState instance;

	@Override
	public void transmit(TCPConnection context, TCPOctetStream stream) {
		
	}

	@Override
	public void activeOpen(TCPConnection context) {
		// TODO Auto-generated provider stub

	}

	@Override
	public void passiveOpen(TCPConnection context) {
		// TODO Auto-generated provider stub

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
		changeState(context, TCPListen.instance);

	}

}
