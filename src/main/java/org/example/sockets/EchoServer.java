package org.example.sockets;

import java.io.*;
import java.net.*;

/**
 * Simple Echo Server
 * - Creates ServerSocket on port
 * - Waits for client connection using accept()
 * - Reads input from client
 * - Sends same data back (echo)
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            // Create ServerSocket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");
            
            // Wait for client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());
            
            // Get input stream from client
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            // Get output stream to client
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            // Read and echo back
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
                writer.println("Echo: " + line);
            }
            
            // Close connections
            socket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
