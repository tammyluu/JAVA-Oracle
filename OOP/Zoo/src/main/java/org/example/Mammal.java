package org.example;

public class Mammal extends Animal {


    public Mammal(int id, String name, String species) {
        super(id, name, species);
    }



    @Override
    public void eat() {
        System.out.println(name + " (Mammal) is eating plants or meat.");
    }
}
