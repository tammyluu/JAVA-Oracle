package org.example.exo16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierCalcul {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int threadCount = 4;
        int size = numbers.length / threadCount;

        AtomicInteger totalSum = new AtomicInteger(0);


        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("Somme totale calculée = " + totalSum.get());
        });

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * size;
            int end = start + size;

            threads[i] = new Thread(() -> {
                int partialSum = 0;
                for (int j = start; j < end; j++) {
                    partialSum += numbers[j];
                }

                System.out.println(Thread.currentThread().getName()
                        + " a calculé une somme partielle de (indice : " + start + " à indice : " + (end - 1) + ") : " + partialSum);

                // Ajouter la somme partielle à la somme totale de manière atomique
                totalSum.addAndGet(partialSum);

                try {
                   barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            threads[i].start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Programme terminé.");
    }

}
