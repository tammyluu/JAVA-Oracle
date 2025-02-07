package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        ActivityJournal.checkFileIsExisted(ActivityJournal.TEXT_FILE);
        ActivityJournal.checkFileIsExisted(ActivityJournal.BINARY_FILE);

        do {
            System.out.println("""
        --- Menu ---
        1. Ajouter une activité
        2. Afficher les activités
        3. Sauvegarder en binaire
        4. Lire le fichier binaire
        5. Quitter
        Choisissez une option :\s"""); // \s : whiteSpace

            choice = sc.nextInt();
            sc.nextLine(); //consume la nouvelle ligne
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