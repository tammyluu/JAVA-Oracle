package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Film> lireFilms(String pathFichier) throws IOException {
        List<Film> films = new ArrayList<Film>();
        try (BufferedReader br  = Files.newBufferedReader(Paths.get(pathFichier), StandardCharsets.UTF_8)){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] split = line.split(",");
                String titre = split[0];
                String year = split[1];
                String gender= split[2];
                String auteur = split[3];
                int entrance = Integer.parseInt(split[4]);
                films.add(new Film(titre,year,gender,auteur,entrance));


            }

        return films;

        }
    }
    public static void main(String[] args) throws IOException {
        List<Film> films = lireFilms("src/films_with_genres 1.csv");

        // Afficher les 10 premiers films
        System.out.println("\n****************Les 10 premiers films*************************");
        films.stream()
                .limit(10)
                .forEach(film -> System.out.println(film));

        System.out.println("\n ***********Les titres des films************");
        films.stream()
                .map(Film::toString)
                .forEach(System.out::println);

        System.out.println("\n*******Films du genre Action************** :");
        films.stream()
                .filter(film -> film.getGenre().equalsIgnoreCase("Action"))
                .forEach(film -> System.out.println(film.getTitre() + " - " + film.getAnnee()));

        System.out.println("\n**********Films réalisés après 2000 :***************");
        films.stream()
                .filter(film -> (film.getAnnee()) >= 2000)
                .map(Film::getTitre)
                .forEach(System.out::println);

        System.out.println("\n****************Films réalisés par Michael Webster :****************");
        films.stream()
                .filter(film -> film.getAuteur().equalsIgnoreCase("Michael Webster"))
                .forEach(film -> System.out.println(film.getTitre() + " - " + film.getAnnee()));

        System.out.println("\n************* Films triés par nombre d'entrées (ordre croissant), top 5 *****************");
        films.stream()
                .sorted(Comparator.comparing(f -> f.getTitre()))
                .limit(5)
                .forEach(film -> System.out.println(film.getTitre() + " - " + film.getAnnee()));

        System.out.println("\n****************Films triés par année de sortie (ordre croissant) :**********************");
        films.stream()
                .sorted(Comparator.comparing(Film::getAnnee))
                .limit(5)
                .map(Film::getTitre)
                .forEach(System.out::println);

        System.out.println("\n********************* Les 10 films avec le plus petit nombre d'entrées :*****************");
        films.stream()
                .sorted(Comparator.comparing(Film::getAnnee))
                .limit(10)
                .forEach(film -> System.out.println(film.getTitre() + " - " + film.getAnnee()));

        //4. Regroupement avec Streams
        System.out.println("\n****************Films regroupés par genre***************** :");
        Map<String, Long> filmparGenre = films.stream()
                .collect(Collectors.groupingBy(Film::getGenre, Collectors.counting()));
        filmparGenre.forEach((genre, count) -> System.out.println(genre + " - " + count));

        System.out.println("\n***************** Films regroupés par réalisateur :*********************");
        Map<String, List<String>> filmPaRealisateur = films.stream()
                .collect(Collectors.groupingBy(Film::getAuteur,Collectors.mapping(Film::getTitre, Collectors.toList())));
        filmPaRealisateur.forEach((realisateur, titres) -> System.out.println(realisateur + " : " +String.join("| ", titres)));

        /* 5. Calculs avec Streams */
        // Calcul du total des entrées pour tous les films
        int totalEntrees = films.stream()
                .mapToInt(Film::getAnnee)
                .sum();
        System.out.println("\nTotal des entrée au cinéma pour tous les films: " + totalEntrees);

        // Trouvez le genre avec le plus grand nombre total d'entrées
        Optional<Map.Entry<String,Integer>> genreMaxEntrees = films.stream()
                .collect(Collectors.groupingBy(Film::getGenre, Collectors.summingInt(Film::getAnnee)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        genreMaxEntrees.ifPresent(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()+ " nombre total d'entrées"));

        //Calculez la moyenne des entrées pour les films d'un réalisateur donné.
        String realisateurDonnee = "Taylor Romero";
        OptionalDouble moyenneEntreesResialiteur = films.stream()
                .filter(film -> film.getAuteur().equals(realisateurDonnee))
                .mapToInt(Film::getAnnee)
                .average();
        DecimalFormat df = new DecimalFormat("#.##");
        moyenneEntreesResialiteur.ifPresent(moyenne -> System.out.println("La moyenne des entrées pour les films de " + realisateurDonnee + " est : " + df.format(moyenne)));

        /*  6.Transformation avec Streams */
        System.out.println("\n******* Liste des films transformée :*************");
        films.stream()
                .map(film -> film.getTitre() + "(" + film.getGenre() + ") - Réalisé par " + film.getAuteur() + " en " + film.getDate())
                .forEach(System.out::println);

        System.out.println("\n**************Genres uniques présents dans le fichier :***********************");
        films.stream()
                .map(Film::getGenre)
                .distinct()
                .forEach(System.out::println);

        /* Questions avancées */
        System.out.println("\n*********** Le premier film (par date) dans chaque genre *********");
        Map<String, Optional<Film>> premierFilmParGenre = films.stream()
                .collect(Collectors.groupingBy(Film::getGenre, Collectors.minBy(Comparator.comparing(Film::getDate))));
    premierFilmParGenre.forEach((genre, film) -> System.out.println("Genre: "
    + genre + " -> Premier film: " + film.orElse(null)));

        // Identifier les réalisateurs ayant réalisé plus de 50 films
        System.out.println("\n******* Les réalisateurs ayant réalisé plus de 50 films***********");
        Map<String, Long> countByDirector = films.stream()
                .collect(Collectors.groupingBy(Film::getAuteur,Collectors.counting()));
        countByDirector.entrySet().stream()
                .filter(entry -> entry.getValue() > 50)
                .forEach(entry -> System.out.println( "\nRéalisateur:  "+ entry.getKey() + " -> Nombre de films:  " + entry.getValue()));


        // Calculez le nombre total d’entrées pour les films sortis entre deux années données (par exemple : 1990 et 2000).
        int total = films.stream()
                .filter(film -> {
                    try {
                        String cleanYear = film.getDate().trim();
                        int year = Integer.parseInt(cleanYear);
                        return year >= 1990 && year<= 2000;

                    }catch (NumberFormatException e) {
                        System.err.println("Année invalide pour le film : " + film.getTitre() + " (" + film.getDate() + ")");
                        return false;
                    }

                })
                .peek(film -> System.out.println("Film inclus : " + film))
                .mapToInt(Film::getAnnee)
                .sum();
        System.out.println("\nTotal des entrées pour les films entre 1990 et 2000 : " + total);

    }





}
