import java.net.*;
import java.io.*;

import java.util.Scanner;
public class MessagingApp {
    public Sms chats[][] = new Sms[100][100];
    int[] chatount = new int[100];
    public Contact contacts[] = new Contact[100];
    private int[] messageIdCounter = new int[100];
    static int countContact = 0;
    private static final int PORT = 4567;

    //finding contactbyname
    public int findContactByname(String name) {
        for (int i = 0; i < countContact; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    //all the methods
    public void addContacts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter receiver's name:");
        String name1 = sc.nextLine();
        System.out.println("Enter number:");
        String number1 = sc.nextLine();
        int existingContact = findContactByname(name1);
        if (findContactByname(name1) != -1) {
            System.out.println("Contact already exists.");
            return;
        }

        if (countContact < contacts.length) {
            contacts[countContact] = new Contact(name1, number1); // Create a Contact object
            System.out.println("Contact added successfully.");
            countContact++;
        } else {
            System.out.println("Contact list is full.");
        }
    }

    //displaying all contacts
    public void displayContacts() {

        if (countContact == 0) {
            System.out.println("No contact found!!");
            return;
        }
        System.out.println("CONTACT LIST:");
        for (int i = 0; i < countContact; i++) {
            System.out.println(contacts[i].toString());
        }
    }

    //deleting contact
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        boolean contactFound = false;
        System.out.println("Enter contact name:");
        String name1 = sc.nextLine();
        for (int i = 0; i < countContact-1; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name1)) {
                contacts[i] = contacts[i+1];
                countContact--;
                System.out.println("Contact " + name1 + " deleted successfully...");
                contactFound = true;
                return;
            }
        }
        if (!contactFound) {
            System.out.println("Contact not found!!!");
        }
    }

/*  public void sendMessage(String name) {
      int contactIndex = findContactByname(name);
      if (contactIndex != -1) {
          Scanner sc1 = new Scanner(System.in);
          while (true) {
              System.out.println("""
                      Enter 1 to enter text message:
                      Enter 2 to enter byte content:
                      """);
              int messageType = sc1.nextInt();
              sc1.nextLine(); // Consume newline

              if (messageType == 0) {
                  return;
              }

              if (messageType == 1) {
                  System.out.println("Enter text message:");
                  String smsContent = sc1.nextLine();
                  TextMessage sms = new TextMessage(smsContent);
                  chats[contactIndex][chatount[contactIndex]] = sms;
                  chatount[contactIndex]++;
                  System.out.println("Text message sent successfully");
              } else if (messageType == 2) {
                  System.out.println("Enter byte data (as a comma-separated list of bytes):");
                  String byteInput = sc1.nextLine();
                  String[] byteStrings = byteInput.split(",");
                  byte[] byteData = new byte[byteStrings.length];
                  for (int i = 0; i < byteStrings.length; i++) {
                      byteData[i] = Byte.parseByte(byteStrings[i].trim());
                  }
                  ByteMessage sms = new ByteMessage(byteData);
                  chats[contactIndex][chatount[contactIndex]] = sms;
                  chatount[contactIndex]++;
                  System.out.println("Byte message sent successfully");
              } else {
                  System.out.println("Invalid option, please try again.");
              }
          }
      } else {
          System.out.println("Contact not found!!!");
      }
  }*/

    //displaying chats
    public void displaychats(String name) {
        int contactIndex = findContactByname(name);

        if (contactIndex != -1) {
            for (int i = 0; i < chatount[contactIndex]; i++) {
                System.out.println(chats[contactIndex][i].toString());
                chats[contactIndex][i].markAsRead();
            }
            if (chatount[contactIndex] == 0) {
                System.out.println("No messages found for this contact.");
            }
        } else {
            System.out.println("Contact not found...!");
        }
    }


    public void deleteMessageByContent(String contactName) {
        int contactIndex = findContactByname(contactName);
        Scanner sc = new Scanner(System.in);
        if (contactIndex != -1) {
            System.out.println("Enter content of the message to delete:");
            String content = sc.nextLine();
            for (int i = 0; i < chatount[contactIndex]; i++) {
                Sms message = chats[contactIndex][i];
                if (message.getContent() != null && message.getContent().equals(content)) {
                    System.out.println("Message deleted: " + message.toString());

                    for (int j = i; j < chatount[contactIndex] - 1; j++) {
                        chats[contactIndex][j] = chats[contactIndex][j + 1];
                    }
                    chats[contactIndex][chatount[contactIndex] - 1] = null;
                    chatount[contactIndex]--;
                }
            }
        } else {
            System.out.println("Contact not found!!!");
        }
    }


    //searhing a specific message by id
    public void searchMessageById(String contactName) {
        int contactIndex = findContactByname(contactName);

        if (contactIndex != -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message ID to search:");
            String messageId = sc.nextLine();

            int messageIndex = findMessageById(contactIndex, messageId);
            if (messageIndex != -1) {
                Sms message = chats[contactIndex][messageIndex];
                System.out.println("Message found: " + message.toString());
            } else {
                System.out.println("Message not found with ID: " + messageId);
            }
        } else {
            System.out.println("Contact not found!!!");
        }
    }

    public void clearChatHistory(String contactName) {
        int contactIndex = findContactByname(contactName);

        if (contactIndex != -1) {
            for (int i = 0; i < chatount[contactIndex]; i++) {
                chats[contactIndex][i] = null;
            }
            chatount[contactIndex] = 0;
            System.out.println("Chat history cleared for contact: " + contactName);
        } else {
            System.out.println("Contact not found!!!");
        }
    }


    private int findMessageById(int contactIndex, String messageId) {
        for (int i = 0; i < chatount[contactIndex]; i++) {
            if (chats[contactIndex][i].getMessageId().equals(messageId)) {
                return i;
            }
        }
        return -1;
    }


    // Method to send a message to a contact
//        public void sendMessage(String name) {
//            int contactIndex = findContactByname(name);
//
//            if (contactIndex != -1) {
//                Scanner sc = new Scanner(System.in);
//
//                // Enter the server IP address of the contact (the server running on their machine)
//                System.out.println("Enter server IP address of " + name + ":");
//                String serverIp = sc.nextLine();
//
//                // Start the client and send message
//                try (Socket socket = new Socket(serverIp, PORT)) {
//                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//
//                    while (true) {
//                        System.out.println("Enter 1 to send a text message:");
//                        System.out.println("Enter 2 to send a byte message:");
//                        System.out.println("Enter 0 to exit:");
//
//
//                        String userChoice = sc.nextLine().trim();
//
//                        // If the user wants to exit the loop
//                        if (userChoice.equals("0") || userChoice.equalsIgnoreCase("exit")) {
//                            System.out.println("Exiting message sending.");
//                            break; // Exit the loop
//                        }
//
//                        // Send a text message
//                        if (userChoice.equals("1")) {
//                            System.out.println("Enter the text message to send to " + name + ":");
//                            String message = sc.nextLine();
//                            output.println("TEXT: " + message);// Send the message to the server
//                            if(message.equals(0) || message.equalsIgnoreCase("exit")){
//                                return ;
//                            }
//
//                            // Read response from server
//                            String response = input.readLine(); // Receive server's response
//                            if (response != null) {
//                                System.out.println("Response from " + name + ": " + response);
//                            }
//
//                        }
//                        // Send a byte message
//                        else if (userChoice.equals("2")) {
//                            System.out.println("Enter the byte data (as comma-separated values) to send:");
//                            String byteInput = sc.nextLine();
//                            String[] byteStrings = byteInput.split(",");
//                            byte[] byteData = new byte[byteStrings.length];
//                            for (int i = 0; i < byteStrings.length; i++) {
//                                byteData[i] = Byte.parseByte(byteStrings[i].trim());
//                            }
//                            output.println("BYTE: " + byteData.length + " bytes"); // Send the byte length or content
//                            // Send the byte data itself
//                            output.write(new String(byteData)); // Send byte array as string (you may want to encode it properly)
//                            output.flush();
//
//                            // Read response from server
//                            String response = input.readLine(); // Receive server's response
//                            if (response != null) {
//                                System.out.println("Response from " + name + ": " + response);
//                            }
//                            if(response.equals(0) || response.equalsIgnoreCase("exit")){
//                                return ;
//                            }
//                        }
//                        // Handle invalid input
//                        else {
//                            System.out.println("Invalid input. Please enter 1, 2, or 0.");
//                            return;
//                        }
//                    }
//                } catch (IOException e) {
//                    System.out.println("Error while connecting to " + name + "'s server: " + e.getMessage());
//                    e.printStackTrace();
//                }
//            } else {
//                System.out.println("Contact not found!!!");
//            }
//        }
    public void sendMessage(String name) {
        int contactIndex = findContactByname(name);

        if (contactIndex != -1) {
            Scanner sc = new Scanner(System.in);

            // Enter the server IP address of the contact (the server running on their machine)
            System.out.println("Enter server IP address of " + name + ":");
            String serverIp = sc.nextLine();

            // Set timeout in milliseconds (e.g., 10 seconds timeout)
            int timeout = 10000; // Timeout of 10 seconds

            // Start the client and send message
            try (Socket socket = new Socket()) {
                // Try to connect with a timeout
                socket.connect(new InetSocketAddress(serverIp, PORT), timeout);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    System.out.println("Enter 1 to send a text message:");
                    System.out.println("Enter 2 to send a byte message:");
                    System.out.println("Enter 0 to exit:");

                    String userChoice = sc.nextLine().trim();

                    // If the user wants to exit the loop
                    if (userChoice.equals("0") || userChoice.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting message sending.");
                        break; // Exit the loop
                    }

                    // Send a text message
                    if (userChoice.equals("1")) {
                        System.out.println("Enter the text message to send to " + name + ":");
                        String message = sc.nextLine();
                        output.println("TEXT: " + message); // Send the message to the server

                        // Read response from server
                        String response = input.readLine(); // Receive server's response
                        if (response != null) {
                            System.out.println("Response from " + name + ": " + response);
                        }

                    }
                    // Send a byte message
                    else if (userChoice.equals("2")) {
                        System.out.println("Enter the byte data (as comma-separated values) to send:");
                        String byteInput = sc.nextLine();
                        String[] byteStrings = byteInput.split(",");
                        byte[] byteData = new byte[byteStrings.length];
                        for (int i = 0; i < byteStrings.length; i++) {
                            byteData[i] = Byte.parseByte(byteStrings[i].trim());
                        }
                        output.println("BYTE: " + byteData.length + " bytes"); // Send the byte length or content
                        // Send the byte data itself
                        output.write(new String(byteData)); // Send byte array as string (you may want to encode it properly)
                        output.flush();

                        // Read response from server
                        String response = input.readLine(); // Receive server's response
                        if (response != null) {
                            System.out.println("Response from " + name + ": " + response);
                        }

                    }
                    // Handle invalid input
                    else {
                        System.out.println("Invalid input. Please enter 1, 2, or 0.");
                    }
                }
            } catch (ConnectException e) {
                System.out.println("Error: Unable to connect to " + name + "'s server. Connection timed out. Please check if the server is running and the IP/port is correct.");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error: Unable to establish connection. " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Contact not found!!!");

        }

    }
}