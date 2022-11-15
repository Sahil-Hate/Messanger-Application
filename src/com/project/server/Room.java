package com.project.server;

import java.util.ArrayList;

public class Room {
	MessageQueue<String> q = new MessageQueue<>();
	ArrayList<User> noslist = new ArrayList<>();
	
	public void MessageDispatch() {
		MessageDispatcher md = new MessageDispatcher(this);
		md.setDaemon(true);
		md.start();
	}

	public ArrayList<User> getNoslist() {
		return noslist;
	}

	public MessageQueue<String> getQ() {
		return q;
	}
	
}
