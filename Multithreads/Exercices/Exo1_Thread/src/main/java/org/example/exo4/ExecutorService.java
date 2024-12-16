package org.example.exo4;

import java.util.concurrent.Executors;

public class ExecutorService {
    public static void main(String[] args) {
        exo4WithExecutorService();
    }

    public static void exo4WithExecutorService() {
        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            executor.submit( ()-> System.out.println("Tâche  " + taskId + " exécutée par " + Thread.currentThread().getName()));

        }
        executor.shutdown();

    }
}
