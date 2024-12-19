package org.example.exo17;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class InventoryManagement {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer>  inventory = new ConcurrentHashMap<>();
        inventory.put("Produit A", 50);
        inventory.put("Produit B", 30);
        inventory.put("Produit C", 40);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable buyTask = () -> {
            for (int i = 0; i < 5; i++) {
                // selection er in produit de manière aléatoire
                String productName = "Produit " +(char) ('B')+" "+ ThreadLocalRandom.current().nextInt(3);
                //décrement le stock si le produit existe et a un stock positif
                inventory.computeIfPresent(productName, (key, value) -> value>0 ?  value - 1 : 0);
                System.out.println(Thread.currentThread().getName() + " a acheté 1 unité de  " + productName);

            }
        };
        Runnable restockTask = () -> {
            for (int i = 0; i < 5; i++) {
                // selection er in produit de manière aléatoire
                String productName = "Produit " +(char) ('B')+" "+  ThreadLocalRandom.current().nextInt(3);
                //restock de 10
                inventory.merge(productName, 10, Integer::sum);
                System.out.println(Thread.currentThread().getName() + "a réapprovicsionné 10 unité de  " + productName);
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(buyTask);
        executor.submit(restockTask);
        executor.submit(buyTask);


        executor.shutdown();

        while(!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("Inventaire final " + inventory);



    }
}
