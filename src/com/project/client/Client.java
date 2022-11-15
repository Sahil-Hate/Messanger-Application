package com.project.client;

import java.net.*;
import javax.swing.*;
import java.io.*;
import com.project.server.*;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Socket soc = new Socket("127.0.0.1", 8080);
		
		BufferedReader nis = new BufferedReader(
				new InputStreamReader(
						soc.getInputStream()
						)
				);
		
		PrintWriter nos = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(soc.getOutputStream())
						), true
				);
		String name = JOptionPane.showInputDialog("Enter Username: ");
		nos.println(name);
		
		String choice = JOptionPane.showInputDialog(
				"**************Menu******************* \n"
				+ "1. To Join Room\n"
				+ "2. Peer to Peer Chat");
		nos.println(choice);
		
		
		if(choice.equals("1")) {
			
			int grp = Integer.parseInt(nis.readLine());
			
			GFrame f = new GFrame(nos, name, grp);
			//f.show();
			
			//Thread.sleep(1000);
			//AddFrame add = new AddFrame(name, grp, f);
			//add.start();
			
			
			JTextArea ta = f.getTextArea();			
			String str = nis.readLine();
			while(!str.equals("End")) {
				ta.append(str+"\n\n");
				str = nis.readLine();
			}
			
			ta.append("Client Signing Off");
		}
		
		
		Thread.sleep(1000);
		System.exit(0);

	}
	

}
