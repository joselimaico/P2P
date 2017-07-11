/*
 * To change this license header, choose License Headers inS Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inS the editor.
 */
package com.Peer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author andres
 */
public class Nodo {
 
     public static void main (String args[]) throws IOException
    {

        if(args.length < 3)
        {
            System.out.println("Debe ingresar: su puerto, el puerto al que quiere comunicarse y el hostname");
            System.exit(-1);
        }
        
        int PortS = Integer.parseInt(args[0]);
        int PortC = Integer.parseInt(args[1]);
        String hostname = args[2];
        
        boolean listening = true;
        
        try
        (
            ServerSocket S = new ServerSocket(PortS);
                
        )
        {
                
            
            while(listening)
            {
                try
                (
                    Socket C = new Socket(hostname, PortC);
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                    PrintWriter writerC = new PrintWriter(C.getOutputStream(),true);
                )
                {
                    Socket clientS = S.accept();
                    BufferedReader readerS = new BufferedReader(new InputStreamReader(clientS.getInputStream()));
                    String input;
                    
                    while((input=stdin.readLine())!=null)
                    {
                        writerC.println(input);
                        System.out.println(readerS.readLine());
                    }
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }                                                    
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
