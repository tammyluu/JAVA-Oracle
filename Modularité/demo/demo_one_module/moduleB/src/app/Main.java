package app;
import myPackage.Person;
import mySecondPackage.Voiture;
import myPackage.subPackage.Animal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> people = new ArrayList<Person>();
    private static Voiture voiture;
    private static Animal animal;

    public static void main(String[] args) {

        people = new ArrayList(List.of(new Person( "Toto",42), new Person( "Bob",43), new Person( "Jack",44)));
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
