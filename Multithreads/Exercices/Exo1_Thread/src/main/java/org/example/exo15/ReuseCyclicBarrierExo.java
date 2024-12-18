package org.example.exo15;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ReuseCyclicBarrierExo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);


        Runnable task = () -> {
            try {
                for (int stage = 1; stage <= 3; stage++) {
                    System.out.println(Thread.currentThread().getName() + " atteint l'étape " + stage);
                    cyclicBarrier.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };


        for (int i = 1; i <= 3; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }




}
