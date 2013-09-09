package org.roqmessaging.management.desktop.wsclient;

class QueueState {
	private boolean State;
	
	QueueState(boolean state) {
		this.State = state;
	}

	boolean isState() {
		return State;
	}

	void setState(boolean state) {
		State = state;
	}
	
}
