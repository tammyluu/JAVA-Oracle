package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static int nonAtomic = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        // sans atomicité
        Thread[] nonAtomicThreads = createNonAtomicThreads();
        for (Thread thread : nonAtomicThreads) thread.start();
        for (Thread thread : nonAtomicThreads) thread.join(); // Attendre la fin de tous les threads
        System.out.println("Valeur finale non atomique : "+nonAtomic);

        // avec atomicité
        Thread[] atomicThreads = createAtomicThreads();
        for (Thread thread : atomicThreads) thread.start();
        for (Thread thread : atomicThreads) thread.join(); // Attendre la fin de tous les threads
        System.out.println("Valeur finale atomique : "+atomicInteger.get());

    }

    private static Thread[] createNonAtomicThreads(){
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    nonAtomic++;
                }
            });
        }
        return threads;
    }

    private static Thread[] createAtomicThreads(){
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
        }
        return threads;
    }
}