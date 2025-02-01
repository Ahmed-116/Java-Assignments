,import javax.swing.*;
import java.util.Scanner;

public class MessagingApp {
    public SMS[][] chats;
    public String[][] contacts;
    public int contactCounter;
    public int[] chatCounter;

    {
        chats = new SMS[100][100];
        contacts = new String[100][2];
        contacts[0][0]= "Ali";
        contacts[0][1]="03247283532";
        contacts[1][0]="Sami";
        contacts[1][1]="03247283476";
        contacts[2][0]="Hamas";
        contacts[2][1]="03247283522";
        contactCounter = 3;
        chatCounter = new int[100];
    }

    public void addContact(String name, String number) {
        contacts[contactCounter][0] = name;
        contacts[contactCounter][1] = number;
        contactCounter++;
        System.out.println("Contact added");
    }

    public void viewContacts() {
        if (contactCounter == 0) {
            System.out.println("Contact list is empty");
        } else {
            System.out.println("CONTACTS:");
            for (int i = 0; i < contactCounter; i++) {

                System.out.println("Name: " + contacts[i][0] + "\t Number: " + contacts[i][1]);
            }
        }
    }


    public void delContact(String name) {


        int contactIndex = searchContactIndexByName(name);
        if (contactIndex != -1) {
            for (int i = contactIndex; i < contactCounter - 1; i++) {

                contacts[i] = contacts[i + 1];
                chats[i] = chats[i + 1];
                chatCounter[i] = chatCounter[i + 1];//.
            }

            System.out.println("Contact removed");

            contactCounter--;


        } else {
            System.out.println("Contact not found");
        }

    }

    public void sendMessage(String senderName, String name) {
        int contactIndex = searchContactIndexByName(name);
        if (contactIndex != -1) {
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("Enter Messages(Press 0 to end)");
                String message = in.nextLine();
                if (message.equals("0")) {
                    break;
                }
                SMS sms = new SMS( name,senderName, message);
                chats[contactIndex][chatCounter[contactIndex]] = sms;//contact index is the index on which
                                                                     //name we type is stored
                chatCounter[contactIndex] = chatCounter[contactIndex] + 1;//.
                System.out.println("Message sent");


            }

        } else {
            System.out.println("Contact not found");
        }
    }

    public void viewChats(String name) {
        int contactIndex = searchContactIndexByName(name);
        if (contactIndex != -1) {
            System.out.println("Your Chat with " + contacts[contactIndex][0] + ":");
            int i=chatCounter[contactIndex];
            if(chatCounter[contactIndex]>0) {
            for ( i = chatCounter[contactIndex] - 1; i >= 0; i--) {          //.
                System.out.println(chats[contactIndex][i].toString());

                chats[contactIndex][i].markAsRead();
            }


            }
            else{
                System.out.println("Chat not found");
            }
        } else {
            System.out.println("Contact not found");
        }

    }
    public void clearChat(String name) {
        int contactIndex = searchContactIndexByName(name);
        if (contactIndex != -1) {
            chats[contactIndex] = null;
            chatCounter[contactIndex] = 0;
            System.out.println("Chat deleted");
        }
        else{
            System.out.println("Contact not found");
        }
    }
    public void delChat(String name,String messageId) {
        int contactIndex = searchContactIndexByName(name);
        if (contactIndex != -1) {
            if(chatCounter[contactIndex]>0) {
                for(int i=0;i<chatCounter[contactIndex];i++) {
                    if(chats[contactIndex][i].getMessageId().equals(messageId)) {
                        for(int j=i;j<chatCounter[contactIndex]-1;j++) {
                            chats[contactIndex][j]=chats[contactIndex][j+1];

                        }
                        chats[contactIndex][chatCounter[contactIndex]-1] = null;
                        chatCounter[contactIndex]--;
                        System.out.println("Message removed");
                        break;
                    }
                }
            }
            else{
                System.out.println("Chat not found");
            }

        }
        else{
            System.out.println("Contact not found");
        }
    }


    public int searchContactIndexByName(String name) {
        for (int i = 0; i < contactCounter; i++) {
            if (contacts[i][0].equals(name)) {
                return i;
            }
        }
        return -1;
    }

}
