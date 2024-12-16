package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Liste de commandes
        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)
        );

        System.out.println("\n1 Afficher toutes les commandes : ");
        commandes.forEach(System.out::println);

        System.out.println("\n2 Afficher le nom des clients de chaque commande");
        commandes.stream()
                .collect(Collectors.groupingBy(Commande::getId))
                .forEach((key, value) -> {
                    System.out.print("La commande numéro " +key + " : " );
                    value.forEach(commande -> System.out.println(commande.getClient()));
                });

        System.out.println("\n3 Afficher le montant total de toutes les commandes.");
        double total = commandes.stream()
                .mapToDouble(Commande::getMontantTotal)
                .sum();
        System.out.println("Le montant total de toutes les commandes est : " + total);

        System.out.println("\n4 Afficher les articles et le prix total pour chaque commande.");
        commandes.forEach(commande -> System.out.println(commande.getClient() + " : " + commande.getId() +" "+commande.getArticles() + " total: " + commande.getMontantTotal() + " €"));

        System.out.println("\n5 Lister les commandes livrées");
        commandes.stream()
                .filter(Commande::isEstLivree)
                .forEach(System.out::println);

        System.out.println("\n6 Calculer le montant total par client");
        Map<String, Double> montantParClient = commandes.stream()
                .collect(Collectors.groupingBy(
                        commande -> commande.getClient(),
                        Collectors.summingDouble(Commande::getMontantTotal)
                ));
        montantParClient.forEach((client, cal) ->
                System.out.println(client + " a dépensé : " + cal + " €"));


        System.out.println("\n7 Obtenir les articles uniques commandés ");
        Set<String> unique = commandes.stream()
                        .flatMap(commande -> commande.getArticles().stream())
                        .collect(Collectors.toSet());
        System.out.println("Articles uniques : " + unique);

        System.out.println("\n8 Vérifier si tous les clients ont une commande livrée");
        Boolean livrable = commandes.stream()
                .collect(Collectors.groupingBy(Commande::getClient))
                .entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().stream().anyMatch(Commande::isEstLivree));
        System.out.println("Tous les clients ont une commande livrée : " + (livrable ? " Oui" : " Non"));

    }
}