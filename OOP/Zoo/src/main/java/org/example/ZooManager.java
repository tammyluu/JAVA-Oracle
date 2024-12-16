package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooManager {
    private List<Enclosure> enclosures;
    private List<Animal> animals;
    public static Scanner scanner = new Scanner(System.in);

    public ZooManager() {
        this.enclosures = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void listAnimals() {
        for (Enclosure enclosure : enclosures) {
            enclosure.listAnimals();
        }
    }


    public void addAnimal(Scanner scanner) {

        System.out.println("Entrez le nom de l'animal : ");
        String name = scanner.nextLine();

        System.out.println("Précisez de l'animal : ");
        String species = scanner.nextLine();

        System.out.println("Entrez l'ID de l'enclos (1: Savane | 2: Jungle:) ");
        int idEnclosure;

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un ID valide !");
            scanner.next();
        }
        idEnclosure = scanner.nextInt();
        scanner.nextLine();

        // Rechercher l'enclos correspondant
        Enclosure enclosure = enclosures.stream()
                .filter(e -> e.getId() == idEnclosure)
                .findFirst()
                .orElse(null);

        if (enclosure == null) {
            System.out.println("Enclos non trouvé !");
            return;
        }

        // Création et ajout de l'animal
        Animal animal = new Mammal(animals.size() + 1, name, species); // Par défaut un Mammifère
        animals.add(animal); // Ajouter à la liste globale
        enclosure.addAnimal(animal); // Ajouter à l'enclos
        System.out.println("Animal ajouté avec succès !");
    }


    private void feedAnimals() {
        // Implémentation de la méthode perform
        ZooAction feedAction = animal -> animal.eat();
        for (Enclosure enclosure : enclosures) {
            enclosure.performActionOnAnimals(feedAction);
        }
    }

    private void removeAnimal(Scanner scanner) {
        System.out.println("Choisissez un enclos:");
        for (int i = 0; i < enclosures.size(); i++) {
            System.out.println((i + 1) + ". " + enclosures.get(i).getName());
        }
        int enclosureChoice = scanner.nextInt();
        scanner.nextLine();

        if (enclosureChoice > 0 && enclosureChoice <= enclosures.size()) {
            Enclosure enclosure = enclosures.get(enclosureChoice - 1);
            enclosure.listAnimals();
            System.out.print("Entrez le nom de l'animal à supprimer: ");
            String animalName = scanner.nextLine();

            Animal toRemove = enclosure.getAnimals().stream()
                    .filter(animal -> animal.name.equalsIgnoreCase(animalName))
                    .findFirst()
                    .orElse(null);

            if (toRemove != null) {
                enclosure.removeAnimal(toRemove);
            } else {
                System.out.println("Animal introuvable dans cet enclos.");
            }
        } else {
            System.out.println("Enclos invalide.");
        }
    }
    public void interactWithMenu() {

        while (true) {
            System.out.println("Menu Zoo:");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Lister les animaux");
            System.out.println("3. Nourrir les animaux");
            System.out.println("4. Déplacer un animal");
            System.out.println("5. Quitter");
            System.out.print("Choix: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimal(scanner);
                case 2 -> listAnimals();
                case 3 -> feedAnimals();
                case 4 -> removeAnimal(scanner);
                case 5 -> {
                    System.out.println("Au revoir!");
                    return;
                }
                default -> System.out.println("Choix invalide, réessayez.");
            }
        }
    }

}
