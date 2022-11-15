/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.client;

import com.project.server.GServer;

/**
 *
 * @author asthathakur
 */
public class GManager extends Thread{
    
    String username;
   
    public GManager(String username ) {
        this.username = username;
      
    }
   
    @Override
    public void run() {
        
        GClient gc = new GClient(username);
        //GServer gs = new GServer();
        //gs.start();
        gc.start();
        
    }
    
    
}
