package org.example;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private  int id;
    private  String name;
    private List<Animal> animals ;

    public Enclosure(int id, String name, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.animals = new ArrayList<>();
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getDetails() + " added to " + name);
    }
    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getDetails() + " retiré de " + name);
        } else {
            System.out.println("Animal introuvable dans " + name);
        }
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in " + name);
        } else {
            System.out.println("Animals in " + name + ":");
            animals.forEach(animal -> System.out.println("- " + animal.getDetails()));
        }
    }
    public void performActionOnAnimals(ZooAction action) {
        for (Animal animal : animals) {
            action.perform(animal);
        }
    }


    public List<Animal> getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
