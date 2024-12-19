package org.example.exo19;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExo {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String element = "Producer-Element-" + i;
                queue.add(element);
                System.out.println("Producer a ajouté : " + element);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String removedElement = queue.poll();
                if (removedElement != null) {
                    System.out.println("Consumer a retiré : " + removedElement);
                } else {
                    System.out.println("Consumer n'a trouvé aucun élément à retirer.");
                }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("État final de la file : " + queue);
    }
}

