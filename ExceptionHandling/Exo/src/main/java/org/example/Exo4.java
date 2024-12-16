package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exo4 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Gestion de la liste d'étudiants ===");

        while (true) {
            try {
                System.out.print("Entrez le nom de l'étudiant (ou 'exit' pour quitter) : ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Entrez l'âge de l'étudiant : ");
                int age = Integer.parseInt(scanner.nextLine());

                // Vérification de l'âge
                if (age < 0) {
                    throw new InvalidAgeException("L'âge d'un étudiant ne peut pas être négatif.");
                }

                students.add(new Student(name, age));
                System.out.println("Étudiant ajouté avec succès !");

            } catch (InvalidAgeException e) {
                System.out.println("Erreur : " + e.getMessage());
                System.out.println("Veuillez saisir à nouveau les informations de l'étudiant.");
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un âge valide (nombre entier).");
            }
        }


        System.out.println("\n=== Liste des étudiants ===");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();


    }
}
