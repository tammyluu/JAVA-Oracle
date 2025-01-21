package org.example.exo7.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



@Table(name = "users")
public class User {
    @Id
    private int id;
    private String name;
    private  String email;
    private boolean active;

    public User() {
    }

    public User(int id, String name, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
