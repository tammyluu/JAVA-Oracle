package org.example.dinausaursspringbatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dinosaur {
    @Id
    private int id;
    private String name;
    private String species;
    private double ageInCenturies;


    public double getAgeInCenturies() {
        return ageInCenturies;
    }

    public void setAgeInCenturies(double ageInCenturies) {
        this.ageInCenturies = ageInCenturies;
    }

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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
