package org.example.exo8;

import java.util.concurrent.atomic.AtomicInteger;

public class Exo8 {

 private static AtomicInteger counter = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        Thread[] atomicThreads = createAtomicThreads();
        for (Thread thread : atomicThreads) thread.start();
        for (Thread thread : atomicThreads) thread.join();
        System.out.println("Valeur finale du compter: "+counter.get());

    }

    private static Thread[] createAtomicThreads() {
        Thread[] atomicThreads = new Thread[5];
        for (int i = 0; i < atomicThreads.length; i++) {
            atomicThreads[i] = new Thread(() -> {
                for (int j = 0; j <2000 ; j++) {
                    counter.incrementAndGet();
                }
            });

        }
        return atomicThreads;

    }
}
