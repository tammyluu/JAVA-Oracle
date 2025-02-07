package org.example;

import java.io.Serializable;

public class Monster implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int strength;
    public Monster(String name, int strength) {
        this.name = name;
        this.strength = strength;
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
}
