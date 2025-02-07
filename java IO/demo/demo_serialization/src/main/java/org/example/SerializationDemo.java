package org.example;

import java.io.*;

public class SerializationDemo {
    public static void runSerializationDemo(){
        System.out.println("La sérialisation ......");
        Student student = new Student(22, "Bob", "toto");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Objet serialisé : " + student);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void runDeserializationDemo(){
        System.out.println("La désérialisation ......");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student student = (Student)ois.readObject();
            System.out.println("Objet déserialisé : " + student);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
