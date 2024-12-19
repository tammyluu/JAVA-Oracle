package org.example.exo18;

import java.util.concurrent.CopyOnWriteArrayList;

public class ProductAdder implements Runnable {
    private final CopyOnWriteArrayList<String> list;
    private final String threadName;

    public ProductAdder(CopyOnWriteArrayList<String> list, String threadName) {
        this.list = list;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            String product = threadName + "-Produit-" + i;
            list.add(product);

           try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

