/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Peer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author andres
 */
public class ThreadS extends Thread{
    
    //ServerSocket S= null;
    int PortS;
    
    
    public ThreadS(int PortS) 
    {
        this.PortS = PortS;
    }
    
    public void run()
    {
        try
            
            (ServerSocket S=new ServerSocket(PortS);
              Socket Csocket=S.accept();
                BufferedReader readerS = new BufferedReader(new InputStreamReader(Csocket.getInputStream()));  
                )
        {
            
            String input;
            boolean listening=true;
            
            while(listening)
            {
                
                
           
                input=readerS.readLine();
                System.out.println(input);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
