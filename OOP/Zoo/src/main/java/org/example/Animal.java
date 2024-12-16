package org.example;

public  abstract class Animal {
    protected  int id;
    protected  String name;;
    protected String species;

    public Animal(int id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }
    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }
    public String getName() {
        return name;
    }

    public  String getDetails(){
        return name + " (" + species + ")";
    };
    public  abstract void  eat();
}
