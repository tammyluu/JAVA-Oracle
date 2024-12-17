package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        demoWithoutSynchronization();
        demoWithSynchronization();
        demoWithReentrantLock();
    }
    // classe pour gerer un compteur partager
    static  class IdGenerator {
        private static int id = 0;

        public  static int generateId() {
            return id++;
        }
    }
    private  static final Object lock = new Object(); // n'a pas d'obliger d'utiliser new class Object
    private static final Lock reentrantLock = new ReentrantLock();

    // demo sans synchronisation
    private static void demoWithoutSynchronization() throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 1000; i++) {
                int id = IdGenerator.generateId();

            }
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur sans synchronisation " + IdGenerator.id);
    }

    // demo avec bloc synchro
    private static void demoWithSynchronization() throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    int id = IdGenerator.generateId();
                }
               // int id = IdGenerator.generateId();// tous les threads en même temps, on traite à partir cette ligne

            }
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur avec synchronisation " + IdGenerator.id);

    }

    // demo avec ReentrantLock
    private static void demoWithReentrantLock() throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 1000; i++) {
                reentrantLock.lock();// acquérir le verrou
                try {
                    int id = IdGenerator.generateId();

                }finally {
                    reentrantLock.unlock();
                }
            }
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur avec ReentrantLock" +
                " " + IdGenerator.id);
    }

    // Methode pour créer des threads
    private static Thread[] createThreads(Runnable task) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
        }
        return threads;
    }

    // Mehode pour démarrer et attendre la fin de mes threads
    private static void runThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }


}
