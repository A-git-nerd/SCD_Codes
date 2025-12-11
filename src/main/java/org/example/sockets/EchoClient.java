package org.example.sockets;

import java.io.*;
import java.net.*;

/**
 * Simple Echo Client
 * - Connects to server using Socket(hostname, port)
 * - Sends messages to server
 * - Receives echoed messages back
 */
public class EchoClient {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost on port 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server");
            
            // Get output stream to server
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            // Get input stream from server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            // Read from console
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            
            // Send and receive
            String userInput;
            System.out.println("Type messages (type 'exit' to quit):");
            while ((userInput = consoleReader.readLine()) != null) {
                if (userInput.equals("exit")) {
                    break;
                }
                
                // Send to server
                writer.println(userInput);
                
                // Receive echo from server
                String response = reader.readLine();
                System.out.println("Server response: " + response);
            }
            
            // Close connection
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
