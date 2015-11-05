package org.suw.learn.pattern.design.state;

class TCPEstabilished implements TCPState {
	static TCPState instanse = new TCPClosed();

	@Override
	public void transmit(TCPConnection context, TCPOctetStream stream) {
		context.ProcessOctet(stream);
		

	}

	@Override
	public void activeOpen(TCPConnection context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void passiveOpen(TCPConnection context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(TCPConnection context) {
		changeState(context, TCPListen.instance);
	}

	@Override
	public void open(TCPConnection context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void synchronize(TCPConnection context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acknowledge(TCPConnection context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(TCPConnection context) {
		// TODO Auto-generated method stub

	}

}
