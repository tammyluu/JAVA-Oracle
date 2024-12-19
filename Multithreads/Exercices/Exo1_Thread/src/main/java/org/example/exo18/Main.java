package org.example.exo18;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> sharedList  = new CopyOnWriteArrayList<>();

       // Thread thread1 = new Thread(new ProductAdder(sharedList, "Thread-1"));
        Thread thread2 = new Thread(new ProductAdder(sharedList, "Thread-2"));

        Thread thread1 = new Thread(() -> {
            sharedList.add(Thread.currentThread().getName());
        });



        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Liste finale des produits : " + sharedList);
    }
}
