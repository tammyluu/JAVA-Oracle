package org.example;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            MonPremierThread thread = new MonPremierThread();
            System.out.println( thread.getName() + i);
            thread.start();
        }

    }
}