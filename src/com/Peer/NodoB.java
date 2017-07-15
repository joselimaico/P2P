/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Peer;

import java.io.IOException;




/**
 *
 * @author andres
 */
public class NodoB 
{
    
    public static void main (String args[]) throws IOException, InterruptedException
    {
       
        if(args.length < 3)
        {
            System.out.println("Debe ingresar: su puerto, el puerto al que quiere comunicarse y el hostname");
            System.exit(-1);
        }
        
        int PortS = Integer.parseInt(args[0]);
        int PortC = Integer.parseInt(args[1]);
        String hostname = args[2];
        System.out.println(PortS);
        System.out.println(PortC);
        System.out.println(hostname);
        ThreadS S = new ThreadS(PortS);
        ThreadC C = new ThreadC(hostname, PortC);
        
        
        while(true){
            try{
            S.start();
        Thread.sleep(10000);
        C.start();
        
            }
            catch(Exception e)
            {
             
            //C.start();
                
            }
        }
       
       
    }

}
