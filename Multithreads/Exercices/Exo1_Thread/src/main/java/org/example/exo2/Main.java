package org.example.exo2;

public class Main {
    public static void main(String[] args) {
        // Implémentation de `Runnable`
        for (int i = 1; i <= 5; i++) {

            Thread thread2 = new Thread(new MyTaskRunnable(i));
            thread2.start();
        }
    }
}
