package org.example.exo16;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierCalcul {
    public static void main(String[] args) {
         int[] tabs = {1,2,3,4,5,6,7,8};
         int numberOfThreads = 4;
         int chunkSize = tabs.length/numberOfThreads;
         
         int[] partialSums = new int[numberOfThreads];
         
         CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, ()->{
             int total = 0;
             for ( int sum :partialSums){
                 total += sum;
             }
             System.out.println("Somme total = " + total);
         });

        for (int i = 0; i <numberOfThreads ; i++) {
            final int index = i;
            new Thread(()->{
                int start = index*chunkSize;
                int end = (index == numberOfThreads-1) ? tabs.length :start + chunkSize;

                int partialSum = 0;
                for (int j = 0; j < end ; j++) {
                    partialSum += tabs[j];
                    
                }
                partialSums[index] = partialSum;
                System.out.println(Thread.currentThread().getName() + " a calculé une somme partielle de (indice : " + start +" à indice : " + (end - 1 + " ) : " + partialSum));
            }).start();
            
        }
    }
}
