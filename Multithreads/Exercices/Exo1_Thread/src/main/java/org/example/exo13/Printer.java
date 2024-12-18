package org.example.exo13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

    private final Lock lock = new ReentrantLock();

    public void print(String taskName) {
        System.out.println(taskName + " tente d'utiliser l'imprimante...");
        try {

            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(taskName + " a acquis le verrou et utilise l'imprimante.");
                    Thread.sleep(1000);
                } finally {
                    System.out.println(taskName + " a terminé d'utiliser l'imprimante et libère le verrou.");
                    lock.unlock();
                }
            } else {
                System.out.println(taskName + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé).");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(taskName + " a été interrompu.");
        }
    }
    static class PrintTask implements Runnable {
        private final Printer printer;

        public PrintTask(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            printer.print(Thread.currentThread().getName());
        }
    }

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
