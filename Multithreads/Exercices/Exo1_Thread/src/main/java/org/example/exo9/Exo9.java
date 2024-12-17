package org.example.exo9;

import java.util.concurrent.atomic.AtomicInteger;

public class Exo9 {


    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);
        int numThreads = 10 ;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads ; i++) {
            threads[i] = new Thread(() -> {
                while (true){
                    int actualValue = count.get();
                    if (actualValue  <10) {
                        boolean success = count.compareAndSet(actualValue,actualValue + 1);
                        if (success) {
                            System.out.println(Thread.currentThread().getName() + " a incrémenté le compteur à " + (actualValue + 1));
                            break;

                        }

                    }else {
                        break;
                    }
                }
            });
        }
        for (int i = 0; i < numThreads ; i++) {
            threads[i].start();
        }
        for (int i = 0; i < numThreads ; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Valeur finale du compteur : " + count.get());
    }
}
