package org.example.demo1;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService {

    public  Person save (int id, String name ,int age){
        return  new Person(name,age,id);
    }
}
