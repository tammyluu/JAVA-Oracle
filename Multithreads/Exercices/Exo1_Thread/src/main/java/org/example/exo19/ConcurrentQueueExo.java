package org.example.exo19;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExo {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                String element = "Producer-Element-" + i;
                queue.add(element);
                System.out.println("Producer a ajouté : " + element);

            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                String removedElement = queue.poll(); // retire et retourne le premier element ou nut si la file est vide
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (removedElement != null) {
                    System.out.println("Comsumer a retiré : " + removedElement);
                } else {
                    System.out.println( "Consumer n'a trouvé aucun élément à retirer.");
                }

            }
        };
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

       producerThread.join();
       consumerThread.join();

        System.out.println("État final de la file : " + queue);
    }
}

