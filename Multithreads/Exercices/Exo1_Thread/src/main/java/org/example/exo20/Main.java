package org.example.exo20;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10_000;

        //Mesure mémoire avec un objet Runtime
        Runtime runtime = Runtime.getRuntime();

        //messure la mémoire avant threads natifs
        System.out.println("memoire avant threads natis en MB " + ((runtime.totalMemory() - runtime.freeMemory())/(1024*1024)));

        // threads natif
        long startTime = System.currentTimeMillis();
        var nativeExecutor = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            nativeExecutor.execute(()->{
                long sum = 0;
                for (int j = 0; j < 1_000_000; j++) {
                    sum += j;
                }

            });
        }
        nativeExecutor.shutdown();
        if(!nativeExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println(" Les threads natifs n'on pas terminé à temps");

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Temps pour les threads natifs : "+ (endTime - startTime));

        //mesure de lamemoire apres les threads natifs
        System.out.println("Mémoire après les threads natifs en MB : "+ ((runtime.totalMemory() - runtime.freeMemory())/(1024*1024)));

        //mesure de lamemoire apres les threads virtuels
        long startVirtualtime = System.currentTimeMillis();
         try (var nativeExecutorVirtual = Executors.newVirtualThreadPerTaskExecutor()){
             for (int i = 0; i < threadCount; i++) {
                nativeExecutorVirtual.execute(()->{
                    long sum = 0;
                    for (int j = 0; j < 1_000_000; j++) {
                        sum += j;
                    }
                });
             }

         }
        long endVirtualtime = System.currentTimeMillis();
        System.out.println("Temps pour les threads virtuels: "+(endVirtualtime - startVirtualtime));
        System.out.println("Memoire après les threads virtuels: "+((runtime.totalMemory() - runtime.freeMemory())/(1024*1024)));
    }
}
