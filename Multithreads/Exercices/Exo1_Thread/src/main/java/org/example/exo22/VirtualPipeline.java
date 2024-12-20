package org.example.exo22;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualPipeline {
    public static void main(String[] args) {
        int count = 10;
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Pipeline de traitement parallèle avec " +count + "tâches.....");
            for (int i = 0; i < count; i++) {
                int taskId = i;
                CompletableFuture<Void> pipeline = CompletableFuture.runAsync(() -> readData(taskId), executor)
                        .thenRunAsync(()-> processData(taskId), executor)
                        .thenRunAsync(()->storeData(taskId), executor);

                // Bloquer jusqu'à ce que le pipeline soit terminé pour chaque tâche
                pipeline.join();
                }
            }
        }


    public static void  readData(int taskId){
        System.out.println("Tâche " + taskId + " : Lecture des données.....");
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Erreur lors de la lecture des données pour la tâche " + taskId + " : "+ e.getMessage());
        }
    }
    public static void processData(int taskId){
        System.out.println("Tâche " + taskId + " : traitement des données.....");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public static void storeData(int taskId){
        System.out.println("Tâche " + taskId  + " : stockage des données.....");
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
