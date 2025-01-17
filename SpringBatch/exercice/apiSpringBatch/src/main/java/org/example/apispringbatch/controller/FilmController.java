package org.example.apispringbatch.controller;

import org.example.apispringbatch.entity.Film;
import org.example.apispringbatch.service.FilmService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")

public class FilmController {

    private final FilmService filmService;

    private final JobLauncher jobLauncher;
    private final Job importJob;

    public FilmController(FilmService filmService, JobLauncher jobLauncher, Job importJob) {
        this.filmService = filmService;
        this.jobLauncher = jobLauncher;
        this.importJob = importJob;
    }

    /**
     * Lancer le traitement des films à partir du fichier CSV
     */
    @PostMapping("/import")
    public ResponseEntity<String> importFilms(@RequestParam("file") MultipartFile file) {
        try {
            // Traitement du fichier CSV
            filmService.processCsv(file);

            // Définir les paramètres du job
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis()) // Un paramètre unique pour chaque exécution
                    .toJobParameters();

            // Lancer le job
            jobLauncher.run(importJob, jobParameters);

            // Retourner une réponse HTTP 200 si le job démarre correctement
            return ResponseEntity.ok("Film import job has been started successfully.");

        } catch (Exception e) {
           return ResponseEntity.internalServerError().body("An error occurred while starting the film import job: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Film>> getFilmById(@PathVariable("id") int id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Film>> getFilmByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(filmService.getFilmByName(name));
    }

    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        return ResponseEntity.ok(filmService.saveFilm(film));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFilm(@PathVariable("id") int id, @RequestBody Film updatedFilm) {
        Optional<Film> isUpdated = filmService.updateFilm(id, updatedFilm);
           return ResponseEntity.ok("Film updated successfully.");

    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable("id") int id) {
        filmService.deleteFilm(id);
    }


}
