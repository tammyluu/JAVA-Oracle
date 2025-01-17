package org.example.apispringbatch.service;

import lombok.RequiredArgsConstructor;
import org.example.apispringbatch.entity.Film;
import org.example.apispringbatch.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void processCsv(MultipartFile file) throws IOException {

        Path path = Paths.get("src/main/resources/films.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            // Ignore the header line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                // Créer une instance de Film
                Film film = new Film();
                film.setName(values[1]);
                film.setDate(values[2]);
                film.setDirector(values[3]);
                film.setGenre(values[4]);
//                film.setSpectator(Long.parseLong(values[3]));
                // Traitement de la colonne Spectator avec gestion d'erreur
                try {
                    film.setSpectator(Long.parseLong(values[5]));
                } catch (NumberFormatException e) {
                    System.err.println("Erreur de format pour le nombre de spectateurs: " + values[3] + " pour le film: " + values[0]);
                    film.setSpectator(0); // ou une valeur par défaut


                    // Enregistrer dans la base de données
                    filmRepository.save(film);
                }
            }
        }

        // Suppression du fichier après traitement
        File tempFile = new File(path.toString());
        if (tempFile.exists()) {
            boolean isDeleted = tempFile.delete();
            if (!isDeleted) {
                throw new IOException("Failed to delete file after processing.");
            }
        }
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
    public Optional<Film> getFilmById(int id) {
        return filmRepository.findById(id);
    }
    public  Optional<Film> getFilmByName(String name) {
        return filmRepository.findFilmByNameContainingIgnoreCase(name);
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public Optional<Film> updateFilm(int id, Film updatedFilm) {
        return filmRepository.findById(id)
                .map(existingFilm -> {
                    existingFilm.setName(updatedFilm.getName());
                    existingFilm.setDate(updatedFilm.getDate().toString());
                    existingFilm.setDirector(updatedFilm.getDirector());
                    existingFilm.setGenre(updatedFilm.getGenre());
                    existingFilm.setSpectator(updatedFilm.getSpectator());

                    return filmRepository.save(existingFilm);
                });
    }
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
        System.out.println("Film deleted by id : " + id);
    }
}
