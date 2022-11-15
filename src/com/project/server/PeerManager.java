package com.project.server;

import com.project.client.*;

public class PeerManager extends Thread{

	String peer1;
	String peer2;
	
	public PeerManager(String peer1 , String peer2) {
		this.peer1 = peer1;
		this.peer2 = peer2;
	}
	
	@Override
	public void run() {
		Peer1 p1 = new Peer1(peer1);
		Peer2 p2 = new Peer2(peer2);
		p2.start();
		p1.start();
	}
}
