package org.example.exo9;

import java.util.concurrent.atomic.AtomicInteger;

public class Exo9 {


    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                while (true){
                    int actualValue = count.get();
                    if (actualValue < 10) {
                        // compareAndSet : verifier et met à jour  la valeur de manière atomique
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
            threads[i].start();
        }

        /*for (int i = 0; i < 10 ; i++) {
            threads[i].start();
        }*/
        for (int i = 0; i < 10 ; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Valeur finale du compteur : " + count.get());
    }
}
