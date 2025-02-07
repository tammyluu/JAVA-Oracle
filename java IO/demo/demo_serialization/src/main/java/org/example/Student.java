package org.example;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
    private transient String password;

    public Student(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
