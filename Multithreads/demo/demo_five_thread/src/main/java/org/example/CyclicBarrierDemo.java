package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        //demoSimpleBarrier();
        //demoCyclicWithBarrier();
            demoCyclicReuse();
    }

    //synchronisation avec cclic barrier
    private static void demoSimpleBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " atteint la barrière");
                cyclicBarrier.await(); // attendre que tous les threads atteigne ce point
                System.out.println(Thread.currentThread().getName() + " continue après la barrier");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task, "Thread " + i).start();
        }
    }

    // demo avec une acion barrière
    public static void demoCyclicWithBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println(" Tous les threads ont atteint la barrier. Action execute");
        });
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " atteint la barrière");
                barrier.await(); // attendre que tous les threads atteigne ce point
                System.out.println(Thread.currentThread().getName() + " continue après la barrier");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread " + i).start();
        }

    }

    // reutilicer de cycliBarbier
    public static void demoCyclicReuse() {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println(" Tous les threads ont atteint la barrier. Action execute");
        });
        Runnable task = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " atteint la barrière");
                    barrier.await(); // attendre que tous les threads atteigne ce point

                }
                System.out.println(Thread.currentThread().getName() + " termine");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }


            };
        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread " + i).start();


        }

    }
}