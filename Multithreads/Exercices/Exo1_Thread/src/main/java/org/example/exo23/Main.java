package org.example.exo23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();
        platform.initCatalogue();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Utilisateur(i,platform));
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)){
                platform.traiteCommande();
            }else {
                System.out.println("Erreur: Les threads ne se sont pas terminés dans le temps imparti.");
            }
        } catch (InterruptedException e) {
            System.out.println( " Erreur lors de l'attente de la fin des threads "+ e.getMessage());
        }
    }
}
