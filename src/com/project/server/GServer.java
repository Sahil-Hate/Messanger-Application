/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.server;


import java.net.*;
/**
 *
 * @author asthathakur
 */
public class GServer extends Thread{
    
	public void run() {
		try {
			System.out.println("Server Signing On");
			ServerSocket ss = new ServerSocket(9081);
			Socket soc = ss.accept();
			Conversation c = new Conversation(soc);
			c.start();
			ss.close();
		}catch(Exception ex) {
			
		}
	}
	
}
