package org.example;

public class MonPremierThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {

            System.out.println(getName() + " - Compteur : " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Thread " + getName() + " interrupted");
            }
        }
    }
}

