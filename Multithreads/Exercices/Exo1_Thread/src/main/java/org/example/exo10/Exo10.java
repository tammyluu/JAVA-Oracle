package org.example.exo10;

import java.util.concurrent.atomic.AtomicLong;

public class Exo10 {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong sharedValue = new AtomicLong(1);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            final int multiplicators = i+2;
            threads[i] = new Thread(() -> {
                long value = sharedValue.updateAndGet(v -> v * multiplicators);
                System.out.println(Thread.currentThread().getName() + "multiplicateur : " + multiplicators+" = "+ value);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }


        System.out.println("Valeur finale : " + sharedValue.get());
    }


}
