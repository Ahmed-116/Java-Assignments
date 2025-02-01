//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MessagingApp m1=new MessagingApp();
        while (true){
            System.out.println("""
                      ---------------------
                        WELCOME TO WECHAT
                      ---------------------
                      Enter 1 to add contacts:
                      Enter 2 to view all contacts:
                      Enter 3 to delete contacts:
                      Enter 4 to search contacts by name:
                      Enter 0 to exit:
                    """);
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch (choice){
                case 1:{
                    m1.addContacts();
                    break;
                }
                case 2:{
                   m1.displayContacts();
                    break;
                }
                case 3:{
                   m1.deleteContact();
                    break;
                }
                case 4:{
                    Scanner sc1=new Scanner(System.in);
                    System.out.println("Enter contact name:");
                    String name2=sc1.nextLine();
                    m1.findContactByname(name2);
                    System.out.println("""
                            Enter 1 to send message;
                            Enter 2 to display chat:
                            Enter 3 to search message by id:
                            Enter 4 to delete message by content:
                            Enter 5 to clear chat completely:
                            """);
                    int choice1=sc1.nextInt();
                    switch (choice1){
                        case 1:{
                            m1.sendMessage(name2);
                            break;
                        }
                        case 2:{
                            m1.displaychats(name2);
                            break;
                        }
                        case 3:{
                            m1.searchMessageById(name2);
                            break;
                        }
                        case 4:{
                           m1.deleteMessageByContent(name2);
                            break;
                        }
                        case 5:{
                            m1.clearChatHistory(name2);
                            break;
                        }
                    }
                    break;
                }
                case 0:{
                    return;
                }
            }
        }
    }
}