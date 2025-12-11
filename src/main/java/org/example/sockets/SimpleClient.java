package org.example.sockets;

import java.io.*;
import java.net.*;

/**
 * Basic Client Example
 * Key Socket methods:
 * 
 * Socket:
 * - Socket(hostname, port) - connect to server
 * - getInputStream() - receive data from server
 * - getOutputStream() - send data to server
 */
public class SimpleClient {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket socket = new Socket("localhost", 6000);
            System.out.println("Connected to server");
            
            // Get streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            
            // Communication
            out.println("Hello Server!");
            String response = in.readLine();
            System.out.println("Server says: " + response);
            
            // Close
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
