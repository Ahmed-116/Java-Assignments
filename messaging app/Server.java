//import java.io.*;
//import java.net.*;
//
//public class Server {
//    private static final int PORT = 5999;
//
//    public static void main(String[] args) {
//        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//            System.out.println("Server is running and waiting for connections...");
//            while (true) {
//                Socket clientSocket = serverSocket.accept();  // Accept incoming client connection
//                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
//
//                // Create input/output streams for communication with the client
//                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
//
//                // Handle client messages
//                String clientMessage;
//                while ((clientMessage = input.readLine()) != null) {
//                    System.out.println("Received from client: " + clientMessage);
//
//                    // Send a response back to the client
//                    output.println("Server received: " + clientMessage);
//                }
//
//                // Close the connection when done
//                clientSocket.close();
//            }
//        } catch (IOException e) {
//            System.out.println("Error in Server: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 4567; // Ensure this port is open and not blocked by the firewall

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and listening on port " + PORT);

            while (true) {
                // Accept incoming client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Start a thread to handle client messages
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message); // Echo message back to client
            }
        } catch (IOException e) {
            System.err.println("Client connection error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close client socket: " + e.getMessage());
            }
        }
    }
}
