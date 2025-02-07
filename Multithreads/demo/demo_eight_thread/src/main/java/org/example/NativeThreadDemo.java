package org.example;

import java.util.concurrent.Executors;

public class NativeThreadDemo {
    public static void main(String[] args) {
        int threadCount = 100_000;
        long startTime = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < threadCount; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(1000);// simule une tache
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } // Fermeture de l'executeur

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime)+" ms");
    }
}
