package org.example.exo13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

    private final Lock lock = new ReentrantLock();

    /*
    **Rappel** :
- `lock()` → Attend toujours jusqu'à ce que le verrou soit disponible.
- `tryLock()` → N'attend pas, retourne immédiatement si le verrou n'est pas disponible.
- `tryLock(timeout, TimeUnit)` → Attend jusqu'à ce que le verrou soit disponible ou que le délai soit écoulé.
    */

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


    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();

        Runnable task1 = ()->{
            printer.print("Task1");

        };
        Runnable task2 = ()->{
            printer.print("Task1");

        };
        Runnable task3 = ()->{
            printer.print("Task1");

        };

        Thread t1 = new Thread(task1, "Tâche-1");
        Thread t2 = new Thread(task2, "Tâche-2");
        Thread t3 = new Thread(task3, "Tâche-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Toutes les tâches sont terminées.");
    }



}
