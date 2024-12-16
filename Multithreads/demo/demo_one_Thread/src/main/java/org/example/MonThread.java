package org.example;

public class MonThread  extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MonThread " + getName() + " with class extends.Step: " + i);
            try {
                Thread.sleep(300);
            }catch(InterruptedException e) {
                System.out.println("MonThread " + getName() + " interrupted");
            }
        }
    }
}
