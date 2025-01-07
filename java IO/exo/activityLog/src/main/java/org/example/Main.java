package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        ActivityJournal.checkFileIsExisted(ActivityJournal.TEXT_FILE);
        ActivityJournal.checkFileIsExisted(ActivityJournal.BINARY_FILE);

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter une activité");
            System.out.println("2. Afficher les activités");
            System.out.println("3. Sauvegarder en binaire");
            System.out.println("4. Lire le fichier binaire");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ActivityJournal.addActivity();
                    break;
                case 2:
                    ActivityJournal.showActivities();
                    break;
                case 3:
                    ActivityJournal.saveToBinaryFile();
                    break;
                case 4:
                    ActivityJournal.readFromBinaryFile();
                    break;
                case 5:
                    System.out.println("Quitter");
                default:
                    System.out.println("Option invalide. Veuillez réessayer !!!");
            }
        }while (choice != 5);

        sc.close();

    }
}