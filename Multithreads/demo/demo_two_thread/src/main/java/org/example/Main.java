package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

       // demoExecutorServiceWithRunnable();
       // demoThreadPool();
        demoScheduledExecutorService();

    }

    public static void demoExecutorServiceWithRunnable() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
       executor.execute( ()-> System.out.println("Task avec Runnable: "));
       executor.shutdown();
       executor.awaitTermination(5, TimeUnit.SECONDS);//attend jusqu'à 5 second la fin des tâches

    }
     public static void demoThreadPool(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
         for (int i = 1; i <= 5; i++) {
             int taskId = i;
             executor.submit( ()-> System.out.println("Task  " + taskId + " execute par " + Thread.currentThread().getName()));

         }
         executor.shutdown();
     }

     public static void  demoScheduledExecutorService() throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        //Task differe
        scheduler.schedule( ()-> System.out.println("Task executee apès 3 seconds: "), 3, TimeUnit.SECONDS);

        // Task périodique
        scheduler.scheduleAtFixedRate(()-> System.out.println("Tesk périodique exécuteé "), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(10000);

        scheduler.shutdown();
    }
}