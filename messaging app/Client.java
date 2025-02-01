//import java.util.Scanner;
//import java.io.*;
//import java.net.*;
//
//    public class Client {
//        private static final int PORT = 5999;
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//
//            // Get the server's IP address
//            System.out.println("Enter the server IP address:");
//            String serverIp = sc.nextLine();  // Get the server's IP address (enter manually)
//
//            try (Socket socket = new Socket(serverIp, PORT)) {  // Connect to the server
//                System.out.println("Connected to the server...");
//
//                // Create input/output streams for communication
//                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//
//                // Send and receive messages
//                String message;
//                while (true) {
//                    System.out.println("Enter message to send to server (or 'exit' to quit):");
//                    message = sc.nextLine();
//
//                    if ("exit".equalsIgnoreCase(message)) {
//                        break;  // Exit the loop if the user types "exit"
//                    }
//
//                    // Send message to the server
//                    output.println(message);
//
//                    // Receive the server's response
//                    String serverResponse = input.readLine();
//                    System.out.println("Received from server: " + serverResponse);
//                }
//            } catch (IOException e) {
//                System.out.println("Error in Client: " + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//    }
//
//


import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "127.0.0.1"; // Use "127.0.0.1" for localhost or specify your server IP
    private static final int PORT = 4567;
    private static final int TIMEOUT = 5000; // Timeout set to 5000 ms (5 seconds)

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client() {
        try {
            // Set a timeout and attempt connection
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_IP, PORT), TIMEOUT);

            // If connection is successful
            System.out.println("Connected to the server at " + SERVER_IP + ":" + PORT);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (SocketTimeoutException e) {
            System.err.println("Connection timed out after " + TIMEOUT + " ms");
        } catch (IOException e) {
            System.err.println("Client connection error: " + e.getMessage());
        }
    }

    public void sendMessage(String message) {
        if (socket != null && socket.isConnected()) {
            out.println(message);
            System.out.println("Sent: " + message);

            try {
                // Receive response from the server
                String response = in.readLine();
                System.out.println("Server response: " + response);
            } catch (IOException e) {
                System.err.println("Error reading from server: " + e.getMessage());
            }
        } else {
            System.out.println("Unable to send message. Not connected to server.");
        }
    }

    public void close() {
        try {
            if (socket != null) socket.close();
            if (out != null) out.close();
            if (in != null) in.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.err.println("Error closing client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        if (client.socket != null && client.socket.isConnected()) {
            client.sendMessage("Hello, Server!");
            client.close();
        }
    }
}
