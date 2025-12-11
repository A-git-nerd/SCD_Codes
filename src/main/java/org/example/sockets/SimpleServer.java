package org.example.sockets;

import java.io.*;
import java.net.*;

/**
 * Basic Server Example
 * Key classes and methods from class diagram:
 * 
 * ServerSocket:
 * - ServerSocket(port) - constructor
 * - accept() - waits for client connection, returns Socket
 * 
 * Socket:
 * - getInputStream() - get input from client
 * - getOutputStream() - send output to client
 * - getPort() - get port number
 * - getInetAddress() - get client IP address
 */
public class SimpleServer {
    public static void main(String[] args) {
        try {
            // Create ServerSocket
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server listening on port 6000");
            
            // Wait for client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getInetAddress());
            System.out.println("Client port: " + socket.getPort());
            
            // Get streams
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Communication
            String message = in.readLine();
            System.out.println("Received: " + message);
            out.println("Hello Client!");
            
            // Close
            socket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
