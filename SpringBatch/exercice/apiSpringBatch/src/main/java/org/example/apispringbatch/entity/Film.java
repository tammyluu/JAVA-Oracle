package org.example.apispringbatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDate date;
    private String director;
    private String genre;
    private long spectator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public long getSpectator() {
        return spectator;
    }

    public void setSpectator(long spectator) {
        this.spectator = spectator;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
