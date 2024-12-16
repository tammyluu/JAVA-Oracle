package org.example;

public class MonRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MonThread " + Thread.currentThread().getName() + " with implement Runnalbe class. Step : " + i);
            try {
                Thread.sleep(300);
            }catch(InterruptedException e) {
                System.out.println("MonThread " + Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}
