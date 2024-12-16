package org.example;

public class MyTaskRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println("Le carré de " + i + "est " + i*i);
            try {
                Thread.sleep(300);
            }catch (InterruptedException e) {
                System.out.println("Erreur de thread" + Thread.currentThread().getName());
            }
        }
    }
}
