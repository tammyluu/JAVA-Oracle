package org.example;
import org.example.Event;

import java.io.*;
import java.util.*;

public class AdventureGame {
    private static final String CHARACTERS_FILE = "characters.dat";
    private static final String MONSTERS_FILE = "monsters.txt";
    private static final String EVENTS_FILE = "events.txt";
    private static final String JOURNAL_FILE = "journal.txt";


    private static List<Event> events = new ArrayList<>();
    private static Character player;
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder journal = new StringBuilder();

    public static void main(String[] args) {
        loadEvents();
        showMenu();
    }

    private static void showMenu() {
        System.out.println("--- Bienvenue dans le jeu d'aventure textuelle ! ---");
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Charger un personnage existant");
        System.out.print("Choisissez une option : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                createCharacter();
                break;
            case 2:
                loadCharacter();
                break;
            default:
                System.out.println("Option invalide.");
                showMenu();
                break;
        }
    }

    private static void createCharacter() {
        System.out.print("Entrez le nom de votre héros : ");
        String name = scanner.nextLine();
        System.out.print("Entrez la force (1-100) : ");
        int strength = scanner.nextInt();
        System.out.print("Entrez la santé (1-100) : ");
        int health = scanner.nextInt();
        player = new Character(name,strength,health);

        saveCharacter();
        startAdventure(player);
    }

    private static void loadCharacter() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CHARACTERS_FILE))) {
            player = (Character) ois.readObject();
            startAdventure(player);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement du personnage.");
        }
    }

    private static void saveCharacter() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CHARACTERS_FILE))) {
            oos.writeObject(player);
            System.out.println("Personnage saugardé.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du personnage.");
        }
    }

    private static void loadEvents() {
        try (Scanner fileScanner = new Scanner(new File(EVENTS_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] eventData = fileScanner.nextLine().split(",");
                events.add(new Event(eventData[0], eventData[1], eventData[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur lors du chargement des événements.");
        }
        if (events.isEmpty()) {
            System.out.println("Aucun événement chargé. Veuillez vérifier 'events.txt'.");
            // Exit the program if no events are loaded
            System.exit(1);
        }
    }

    public static void startAdventure(Character player) {
        System.out.println("--- Début de l'aventure pour : " + player + " ---");
        journal.append("Début de l'aventure pour : ").append(player).append("\n");

        if (events.isEmpty()) {
            System.out.println("Aucun événement disponible. L'aventure ne peut pas commencer.");
            return;
        }

        Random rand = new Random();
        int healthLossPerFailure = 10;

        while (player.getHealth() > 0) {
            // Select a random event
            Event event = events.get(rand.nextInt(events.size()));
            System.out.println("Événement : " + event.getDescription());
            journal.append("Événement : ").append(event.getDescription()).append("\n");

            // Handle the event based on its type
            if (event.getAction().equalsIgnoreCase("combat")) {
                // Call combat for monster
                combat();
            } else if (event.getAction().equalsIgnoreCase("chest")) {
                // Call openChest for chest
                openChest();
            } else {
                // General event: Random success or failure
                boolean success = rand.nextBoolean();
                if (success) {
                    System.out.println("Résultat : Succès");
                    journal.append("Résultat : Succès\n");
                } else {
                    System.out.println("Résultat : Échec");
                    journal.append("Résultat : Échec\n");
                    player.setHealth(player.getHealth() - healthLossPerFailure);
                    System.out.println("Santé restante : " + player.getHealth());
                    journal.append("Santé restante : ").append(player.getHealth()).append("\n");
                }
            }

            // Check if the player is still alive
            if (player.getHealth() <= 0) {
                System.out.println("Le héros est mort avant la fin.");
                journal.append("Le héros est mort avant la fin.\n");
                break;
            }

            // Ask the player if they want to continue
            System.out.print("Voulez-vous continuer l'aventure ? (oui/non) : ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("oui")) {
                System.out.println("L'aventure se termine ici. Santé finale : " + player.getHealth());
                journal.append("L'aventure se termine ici. Santé finale : ").append(player.getHealth()).append("\n");
                break;
            }
        }

        System.out.println("--- Fin de l'aventure ---");
        journal.append("--- Fin de l'aventure ---\n");
        saveJournal();
    }




    private static void combat() {
        System.out.println("Vous rencontrez un monstre dans la forêt.");
        Monster monster = new Monster("Géant", 100);
        journal.append("Rencontre avec : Nom : ").append(monster.getName())
                .append(", Force : ").append(monster.getStrength()).append("\n");

        if (player.getStrength() > monster.getStrength()) {
            journal.append("Résultat : Vous avez battu le monstre !\n");
        } else {
            journal.append("Résultat : Défaite. Santé restante : ").append(player.getHealth() - 30).append("\n");
            // Decrease health on defeat
            player.setHealth(player.getHealth() - 30);
        }
    }

    private static void openChest() {
        System.out.println("Vous trouvez un coffre mystérieux.");
        Random rand = new Random();
        if (rand.nextBoolean()) {
            journal.append("Résultat : Vous avez ouvert le coffre et trouvé un trésor !\n");
        } else {
            journal.append("Résultat : Le coffre était piégé ! Vous perdez 10 points de santé.\n");
            player.setHealth(player.getHealth() - 10);
        }
    }
    private static void saveJournal() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_FILE,true))) {
            writer.write(journal.toString());
            System.out.println("Journal saved to " + JOURNAL_FILE);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du journal.");
        }
    }

}
