package app;

import java.util.ArrayList;
import java.util.List;

import myPackage.Person;
import myPackage.subPackage.Animal;
// import mySecondPackage.Voiture;
// import selectivePackage.House;

public class Main {

    private static List<Person> people;

   // private static List<Voiture> voiture; // impossible sans l'export du package mySecondPackage du moduleA

    private static Animal animal;

   // private static List<House> houses; // impossible car l'export du package selectivePackage est autorise
    // uniquement pour le module D

    public static void main(String[] args) {

        people = new ArrayList<>(List.of(new Person("toto",42),new Person("tata",43),new Person("tutu",44)));

        for (Person person : people) {
            System.out.println(person);
        }

    }
}