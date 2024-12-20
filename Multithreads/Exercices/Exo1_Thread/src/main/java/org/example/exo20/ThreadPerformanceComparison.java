package org.example.exo20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPerformanceComparison {
    public static void main(String[] args) {
        int threads = 100_000;
        long nativeStarTime = System.currentTimeMillis();
        try (ExecutorService nativeExecutor = Executors.newFixedThreadPool(100)) {
            for (int i = 0; i < threads; i++) {
                nativeExecutor.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });

            }
            long nativeEndTime = System.currentTimeMillis();
            System.out.println("Temps d'exécution total avec threads natifs: " + (nativeEndTime - nativeStarTime) + " ms");

            long virtualStartTime = System.currentTimeMillis();
            try (ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
                for (int i = 0; i < threads; i++) {
                    virtualExecutor.execute(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
                }
            }
            long virtualEndTime = System.currentTimeMillis();
            System.out.println("Temps d'exécution total avec threads virtuels: " + (virtualEndTime - virtualStartTime) + " ms");

            System.out.println("Analyse des performances:");
            System.out.println("- Threads natifs: " + (nativeEndTime - nativeStarTime) + " ms");
            System.out.println("- Threads virtuels: " + (virtualEndTime - virtualStartTime) + " ms");

        }
    }
}
