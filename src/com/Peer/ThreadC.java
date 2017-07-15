/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Peer;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author andres
 */
public class ThreadC extends Thread {

    //Socket C = null;
    String hostname;
    int PortC;

    public ThreadC(String hostname, int PortC) {
        this.hostname = hostname;
        this.PortC = PortC;
    }

    @Override
    public void run() {
        try (
                Socket C = new Socket(hostname, PortC);
                

                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writerC = new PrintWriter(C.getOutputStream(), true);) {
            

            boolean listening = true;
            while (listening) {

                String input;
                while ((input = stdin.readLine()) != null) {
                    writerC.println(input);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
