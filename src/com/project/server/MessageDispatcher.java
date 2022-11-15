package com.project.server;

import java.io.PrintWriter;

public class MessageDispatcher extends Thread{
	Room r;
	
	public MessageDispatcher(Room r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		while(true) { 
			try {
				String str = r.getQ().dequeue();
				for(User o : r.getNoslist()) {
					PrintWriter nos = o.getNos();
					nos.println(str);
					//o.nos.println(str);
				}
			}catch(Exception e) {
				
			}
		}
	}
}
