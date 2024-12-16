package org.example;

public class Bird extends Animal {
    public Bird(int id, String name, String species) {
        super(id, name, species);
    }


    @Override
    public void eat() {
        System.out.println(name + " Bird is eating seeds or insects.");
    }
}
