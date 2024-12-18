package org.example.exo16;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {
    private static final int[] data = {1,2,3,4,5,6,7,8};
    private static final AtomicIntegerArray paialSum = new AtomicIntegerArray(4);
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4,() ->{
            int totalSum = 0;
            for (int i = 0; i < paialSum.length(); i++) {
                totalSum  += paialSum.get(i);

            }
        });
        for (int i = 0; i < 4; i++) {
            final int index = i;
            new Thread(() -> {
                int start = index * 2 ;
                int end = start +2;
                int partialSum = 0;
                for (int j = start; j < end ; j++) {
                    partialSum += data[j];
                }
                paialSum.set(index, partialSum);
                System.out.println(Thread.currentThread().getName() + " à calculé la somme de partiel de l'indice :  " +start+ " à l' indice"+ (end-1) + " est à égale "+ partialSum);

            }, ("Thread- " + i)).start();
        }

    }
}
