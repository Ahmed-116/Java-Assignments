import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("__________________________");
        System.out.println("Welcome to My MessagingApp");
        MessagingApp messagingApp = new MessagingApp();
        String senderName = "Ahmed";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("__________________________");
            System.out.println("Enter 1 to Send message:");
            System.out.println("Enter 2 to View chats:");
            System.out.println("Enter 3 to Add contact:");
            System.out.println("Enter 4 to Remove contact:");
            System.out.println("Enter 5 to View contacts:");
            System.out.println("Enter 6 to Clear all chats:");
            System.out.println("Enter 7 to Delete specific chat:");
            System.out.println("Enter 0 to Exit:");
            System.out.println("__________________________");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the person you want to chat with:");
                    String name = scanner.next();
                    messagingApp.sendMessage(senderName, name);
                    break;
                case 2:
                    System.out.println("Enter the name of the person you want to view the chat:");
                    String Name = scanner.next();
                    messagingApp.viewChats(Name);
                    break;

                case 3:
                    System.out.println("Enter the name of the person you want to add contact:");
                    String name1 = scanner.next();
                    System.out.println("Enter the number of the person you want to add contact:");
                    String number1 = scanner.next();
                    messagingApp.addContact(name1, number1);
                    break;
                case 4:
                    System.out.println("Enter the name of the person you want to remove contact:");
                    String name2 = scanner.next();
                    messagingApp.delContact(name2);
                    break;
                case 5:

                    messagingApp.viewContacts();
                    break;
                case 6:
                    System.out.println("Enter the name of the person of which you want to clear chats:");
                    String name3 = scanner.next();
                    messagingApp.clearChat(name3);
                    break;
                case 7:
                    System.out.println("Enter the name of the person of which you want to delete chat:");
                    String name4 = scanner.next();
                    System.out.println("Enter the messageId:");
                    String messageId = scanner.next();
                    messagingApp.delChat(name4, messageId);
                    break;


                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);


            }
        }
    }
}
