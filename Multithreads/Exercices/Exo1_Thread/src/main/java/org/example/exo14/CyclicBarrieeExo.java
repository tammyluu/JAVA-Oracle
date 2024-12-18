package org.example.exo14;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrieeExo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            System.out.println(" Fusion des données terminée. Tous les threads peuvent continuer.");
        });
        Runnable task = ( ) -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": commence à charger les données.");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": a terminé le chargement des données.");
                cyclicBarrier.await();

            }catch (Exception e) {
                throw new RuntimeException();
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task, " Thread " + i).start();
        }

    }
}
