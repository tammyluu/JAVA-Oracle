package org.example.exo13;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();

        Thread task1 = new Thread(new PrintTask(printer), "Tâche-1");
        Thread task2 = new Thread(new PrintTask(printer), "Tâche-2");
        Thread task3 = new Thread(new PrintTask(printer), "Tâche-3");

        task1.start();
        task2.start();
        task3.start();

        task1.join();
        task2.join();
        task3.join();

        System.out.println("Toutes les tâches sont terminées.");
    }

}
