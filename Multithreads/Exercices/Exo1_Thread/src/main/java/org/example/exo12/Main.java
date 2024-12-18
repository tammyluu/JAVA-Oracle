package org.example.exo12;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                sharedResource.addElement(i);
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-1");

         Thread thread2 = new Thread(() ->{
             for (int i = 0; i < 5; i++) {
                sharedResource.removeElement();
                 try {
                     Thread.sleep(50);
                 }catch (InterruptedException e){
                     Thread.currentThread().interrupt();
                 }

             }
         }, "Thread-2");

         thread1.start();
         thread2.start();
         thread1.join();
         thread2.join();

    System.out.println("État final de la liste : " + sharedResource.getList());
    }
}
