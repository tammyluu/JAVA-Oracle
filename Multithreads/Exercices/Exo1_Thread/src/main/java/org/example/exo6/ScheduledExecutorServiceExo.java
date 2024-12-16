package org.example.exo6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExo {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        // planifier la premiere tache : les tâches ne se repètent pas
                scheduler.schedule(() -> {
            System.out.println("Tâche 1 exécutée après 1 seconde.");
        }, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Tâche 2 exécutée après 2 seconde.");
        }, 2, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Tâche 3 exécutée après 3 seconde.");
        }, 3, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Toutes les tâches sont terminées.");
        }, 4, TimeUnit.SECONDS);

        scheduler.shutdown();

    }


}

