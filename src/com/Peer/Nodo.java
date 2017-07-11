/*
 * To change this license header, choose License Headers inS Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inS the editor.
 */
package com.Peer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author andres
 */
public class Nodo {
 
    public static void main (String args[])
    {
      
      if (args.length < 2) 
      {
        System.err.println("Usage: java EchoServer <port number>");
        System.exit(1);
      }
    
      int PortS = Integer.parseInt(args[0]);
      
      String hostname = args[1];
     
      boolean listening = true;
      try 
              
       
       // Socket C = new Socket(hostname, PortC);
              
      
      {
          String inputline, outputline;
          //while (listening)
          //{
           ServerSocket S = new ServerSocket(PortS);
          Socket clienteC =S.accept();
          
            
            //C.connect(C.getLocalSocketAddress());
            
             
            
            
            BufferedReader inS = new BufferedReader(new InputStreamReader(clienteC.getInputStream()));
            //PrintWriter outS = new PrintWriter(clienteC.getOutputStream(),true);
            Socket C = new Socket(hostname, PortS);
            
            
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            
            
           // BufferedReader inC = new BufferedReader(new InputStreamReader(C.getInputStream()));
            PrintWriter outC = new PrintWriter(C.getOutputStream(),true);
            
            while((inputline=stdin.readLine())!=null&&(outputline=inS.readLine())!=null)
            {
                
                
                
                outC.println(inputline);
                System.out.println(outputline);
                
                
            }
            
            //S.close();
            //C.close();
          //}
      } 
        
        catch (Exception e) 
        {
            e.getStackTrace();
       	}
    }
}
