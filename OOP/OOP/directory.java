
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class directory {
    private ArrayList<Person> conctacList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public void addContact(String inputName, int inputNumber){
        String newFullname;
        int newNumber;
       while(true){
        System.out.println(inputName);
        newFullname = sc.nextLine().trim().toUpperCase();
        System.out.println(inputNumber);
        newNumber = Integer.parseInt(sc.nextLine());
        if (newFullname.isEmpty()){
        System.out.println("Error Input");
        }else{
            return newFullname;
        }
       }
    }


    
}
