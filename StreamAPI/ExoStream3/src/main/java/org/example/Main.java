package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
      String csvFile = "src/main/resources/books_dataset.csv";
        List<Livre> livres;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            livres=  br.lines()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(value -> new Livre(
                            value[0],
                            value[1],
                            value[2],
                            LocalDate.parse(value[3]),
                            Integer.parseInt(value[4]),
                            Boolean.parseBoolean(value[5]),
                            Double.parseDouble(value[6])))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       /* System.out.println("\n1/ Filtrer les livres disponibles");
        livres.stream()
                .filter(Livre::isEstDisponible)
                .forEach(System.out::println);*/

       /* System.out.println("\n2/ Trouver les livres publiés avant 1950");
        livres.stream()
                .filter(livre -> livre.getDatePublication().isBefore(LocalDate.of(1950,1,1)))
                .forEach(livre -> System.out.println("Titre: " + livre.getTitre() + "Auteur: " + livre.getAuteur()));*/

        /*System.out.println("\n3/ Grouper les livres par genre");
        Map<String, List<Livre>> livresParGenre = livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre));

        livresParGenre.forEach((genre, livresList) -> {
            System.out.println("\n--> Genre: " + genre);
            livresList.forEach(System.out::println);
        });*/

        System.out.println("\n4/ Trouver le livre le plus ancien");
        livres.stream()
                .min(Comparator.comparing(Livre::getDatePublication))
                .stream().limit(1)
                .forEach(livre -> System.out.println("Le livre est plus ancien: " + livre.getDatePublication()));

        System.out.println("\n5/ Vérifier s'il existe des livres dont le titre commence par \"Harry\"");
        Boolean isHarry = livres.stream()
                .anyMatch(livre -> livre.getTitre().equals("Harry"));
        System.out.println("\nIl existe des livres dont le titre commence par 'Harry' : " + isHarry);

       /* System.out.println("\n6/ Calculer le prix moyen des livres");
        double average = livres.stream()
                .filter(Livre::isEstDisponible)
                .mapToDouble(Livre::getPrix)
                .average()
                .orElse(0.0);
        System.out.println("\nLe prix moyen des livres disponibles :" +average );*/

        /*System.out.println("\n7/ Trier les livres par nombre de pages");
        livres.stream()
                .sorted(Comparator.comparing(Livre::getNbPages).thenComparingDouble(Livre::getPrix))
                .forEach(System.out::println);
*/

        System.out.println("\n8/ Calculer le total des pages pour tous les livres de genre \"Fantasy\"");
        int total = livres.stream()
                .filter(livre -> livre.getGenre().equals("Fantasy"))
                .mapToInt(Livre::getNbPages)
                .sum();
        System.out.println("Le total des pages pour tous les livres de genre \"Fantasy\" est : " + total);

        System.out.println("\n9/ Trouver le livre le plus cher");
        livres.stream()
                .filter(Livre::isEstDisponible)
                .max(Comparator.comparing(Livre::getPrix))
                .ifPresent(livre -> System.out.println("Le livre est plus cher : " + livre.getPrix()));

        System.out.println("\n10/ Trouver les auteurs les plus prolifiques** (les auteurs ayant écrit plus de 17 livre) et afficher leurs livres.");
        livres.stream()
              .collect(Collectors.groupingBy(Livre::getAuteur,Collectors.counting()))
              .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 17)
                .forEach(entry -> System.out.println("les auteurs ayant écrit plus de 17 livres est : " + entry.getKey()));

        System.out.println("\n11/ Compter le nombre de livres dans chaque genre");
        livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre,Collectors.counting()))
                .forEach((g, count)-> System.out.println(g + " : " + count));

      /*  System.out.println("\n12/ Vérifier si un livre est disponible et si son prix est inférieur à un seuil donné");

        livres.stream()
                .filter(livre -> livre.isEstDisponible() && livre.getPrix() < 15)
                .forEach(livre -> System.out.println("Le livre est disponible  inférieur à un seuil donné 15 : " + livre.getPrix()));*/

        System.out.println("\n13/ Calculer le nombre total de pages pour les livre de chaque année");

       /* livres.stream()
                .collect(Collectors.groupingBy(livre -> livre.getDatePublication().getYear(), Collectors.summingInt(Livre::getNbPages)))
                .forEach((year, totalPage) -> System.out.println("Année " + year + " : " + totalPage + " pages"));
*/
        Map<Integer, Long> count = livres.stream()
                .collect(Collectors.groupingBy(livre -> livre.getDatePublication().getYear(),Collectors.counting()));
        Map<Integer, Integer> pagesByYear = livres.stream()
                .collect(Collectors.groupingBy(livre -> livre.getDatePublication().getYear(),Collectors.summingInt(Livre::getNbPages)));
        count.forEach((y, c) ->{
          System.out.println("Année " + y + ": " + c + " livres, " +
                  pagesByYear.get(y) + " pages au total");
        });
    }
}