package org.example;

import java.io.Serializable;

public class Character implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int strength;
    private int health;

    public Character(String name, int strength, int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Character: { " +
                "|name " + name + '\'' +
                "|strength " + strength +
                "|health " + health +
                '}';
    }
}
