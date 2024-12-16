 import java.util.ArrayList;

   public class Directory {
       private ArrayList<Person> contacts;

       public Directory() {
           contacts = new ArrayList<>();
       }

       public void addContact(String name, String phone) {
           contacts.add(new Person(name, phone));
       }

       public void displayContacts() {
           for (Person p : contacts) {
               System.out.println(p);
           }
       }
   }