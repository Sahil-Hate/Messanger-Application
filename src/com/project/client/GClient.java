/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.client;

import java.io.*;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 *
 * @author asthathakur
 */
public class GClient extends Thread{
String username;
    
    public GClient(String username){
        this.username = username;
    }
    
    @Override
    public void run() {
        try {
            Socket soc = new Socket("127.0.0.1", 8080);
            
            BufferedReader nis = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter nos = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
            
            nos.println(username);
            nos.println(1);
            int grp = Integer.parseInt(nis.readLine());
            GFrame f = new GFrame(nos, username, grp);
            
            
            JTextArea ta = f.getTextArea();			
			String str = nis.readLine();
			while(!str.equals("End")) {
				ta.append(str+"\n\n");
				str = nis.readLine();
			}
			
			ta.append("Client Signing Off");
            
        }catch(Exception ex) {
            
        }
    }
}
