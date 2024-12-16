 import java.util.Scanner;

   public class Main {
       public static void main(String[] args) {
           Directory directory = new Directory();
           Scanner scanner = new Scanner(System.in);

           while (true) {
               System.out.println("1. Add contact");
               System.out.println("2. Display contacts");
               System.out.println("3. Exit");
               System.out.print("Choose an option: ");

               int choice = scanner.nextInt();
               scanner.nextLine(); // Consume newline

               if (choice == 1) {
                   System.out.print("Enter name: ");
                   String name = scanner.nextLine();
                   System.out.print("Enter phone: ");
                   String phone = scanner.nextLine();
                   directory.addContact(name, phone);
               } else if (choice == 2) {
                   directory.displayContacts();
               } else if (choice == 3) {
                   break;
               } else {
                   System.out.println("Invalid option.");
               }
           }

           scanner.close();
       }
   }