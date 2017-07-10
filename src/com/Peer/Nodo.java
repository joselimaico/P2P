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
      
      if (args.length < 3) 
      {
        System.err.println("Usage: java EchoServer <port number>");
        System.exit(1);
      }
    
      int PortS = Integer.parseInt(args[0]);
      int PortC = Integer.parseInt(args[1]);
      String hostname = args[2];
     
      boolean listening = true;
      try 
      (        
        ServerSocket S = new ServerSocket(PortS);
        Socket C = new Socket(hostname, PortC); 
      )
      {
          String inputline, outputline;
          while (listening)
          {
            //Socket C = new Socket(hostname, PortC); 
            Socket clienteC = S.accept();
            
            BufferedReader inS = new BufferedReader(new InputStreamReader(clienteC.getInputStream()));
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outS = new PrintWriter(clienteC.getOutputStream(),true);
            
            BufferedReader inC = new BufferedReader(new InputStreamReader(C.getInputStream()));
            PrintWriter outC = new PrintWriter(C.getOutputStream(),true);
            
            while((inputline=stdin.readLine())!=null && inS.readLine()!=null)
            {
                
                outC.println(inputline);
                
                System.out.println(inS.readLine());
            }
          }
      } 
        
        catch (Exception e) 
        {
            e.getStackTrace();
       	}
    }
}
