package org.example;

public class DeadBlockExample {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
            synchronized (lock1) {
                System.out.println("Thread 1 verrou 1 acquis ");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                // va demandervle verrou 2 mais ne l'onbient pas car thread 2 le possède dèjà
                synchronized (lock2) {
                    System.out.println("Thread 1 verrou 2 acquis ");
                }
            }

        });

        // second thread qui va prendre le verrou 2 en première
        Thread thread2 = new Thread(() ->{
            synchronized (lock2) {
                System.out.println("Thread 2 verrou  2 acquis ");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                // va demandervle verrou 1 mais ne l'onbient pas car thread 1 le possède dèjà
                synchronized (lock1) {
                    System.out.println("Thread 2 verrou 1 acquis ");
                }
            }

        });
        thread1.start();
        thread2.start();
    }
}
