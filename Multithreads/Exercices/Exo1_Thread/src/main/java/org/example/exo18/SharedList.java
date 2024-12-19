package org.example.exo18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedList {
    public static void main(String[] args) throws InterruptedException {
        List<String> products = new CopyOnWriteArrayList<>();
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                String product = Thread.currentThread().getName() + "Produit "  + i;
                products.add(product);
                System.out.println(product);

            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(task);
        executor.execute(task);
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println(" List final: "+products);
        System.out.println(" Taille de List final: "+products.size());
    }
}
