package com.project.server;

import java.net.*;
import java.util.*;

public class Server {

	public static ArrayList<Room> group = new ArrayList<>();
	//public static ArrayList<User> userlist = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		
		
		System.out.println("Server Signing ON");
		ServerSocket ss = new ServerSocket(8080);
		
		for(int i = 0; i < 5; i++) {
			Room r = new Room();
			group.add(r);
			r.MessageDispatch();
		}
		
		for(int i = 0; i < 10; i++) {
			Socket soc = ss.accept();
			System.out.println("Connection Established with "+soc.getInetAddress().getHostAddress());
			Conversation c = new Conversation(soc);
			c.start();
		}
		
		ss.close();
		System.out.println("Server Signing OFF");		
	}

}

