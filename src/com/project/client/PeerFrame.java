package com.project.client;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PeerFrame {

	private PrintWriter nos;
	private String username;
	
	public PeerFrame(PrintWriter nos, String username){
		this.username = username;
		this.nos = nos;
		init();
	}
	
	private JFrame f1 = new JFrame(username);
	private JButton b1 = new JButton("Send");
	private JTextArea ta = new JTextArea(20, 20);
	private JTextField tf = new JTextField(20);
	private JPanel p1 = new JPanel();
	
	
	void init() {
		ta.setEditable(false);
		p1.add(tf);
		p1.add(b1);
		f1.add(ta);
		f1.add(BorderLayout.SOUTH, p1);
		
		L1 l = new L1(ta, nos, username, tf);
		
		b1.addActionListener(l);
		
		tf.addActionListener(l);
		
		f1.setSize(400, 400);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void show() {
		f1.setVisible(true);
	}
	
	JTextArea getTextArea() {
		return ta;
	}
	
	
}

class L1 implements ActionListener{
	
	JTextArea ta;
	PrintWriter nos;
	String Username;
	JTextField tf;
	
	L1(JTextArea ta , PrintWriter nos, String Username, JTextField tf){
		this.ta = ta;
		this.nos = nos;
		this.Username = Username;
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf.getText();
		String str1 = "\n"+"  "+Username+" >> "+str;
		ta.append(str1);
		nos.println("  "+Username+" >> "+str);
		tf.setText("");
	}
}

