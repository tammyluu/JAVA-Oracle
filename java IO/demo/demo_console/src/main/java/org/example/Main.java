package org.example;

import java.io.Console;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Demontration Console: ");

        //Obtenu ine instance de console
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available.");
            return;
        }
        //lire entrée utilisateur
        String username = console.readLine("Enter your username: ");

        //lire un mot de passe
        char[] password = console.readPassword("Enter your password: ");

        //affichage
        console.printf("%s\n", username);

        //nettoyer les données sensibles
        Arrays.fill(password, '*');



    }
}