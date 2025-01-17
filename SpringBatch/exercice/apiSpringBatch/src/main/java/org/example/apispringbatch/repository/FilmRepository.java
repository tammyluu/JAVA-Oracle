package org.example.apispringbatch.repository;

import io.micrometer.observation.ObservationFilter;
import org.example.apispringbatch.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findFilmByNameContainingIgnoreCase(String name);


}
