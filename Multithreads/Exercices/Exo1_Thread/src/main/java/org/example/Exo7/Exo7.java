package org.example.Exo7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exo7 {



    public static void main(String[] args) {
        ScheduledExecutorService sch = Executors.newSingleThreadScheduledExecutor();


        AtomicInteger count = new AtomicInteger(0);
        int max = 5;
        sch.scheduleAtFixedRate(()->{
            int i = count.incrementAndGet();
            System.out.println("Message périodique " + i);
            if (i == 5) {
                sch.shutdown();
                System.out.println("Programme terminé. ");

            }
        },1 ,2,TimeUnit.SECONDS);

       /* Runnable task = () -> {
            int i = count.incrementAndGet();
            System.out.println("Message périodique " + count);

            if (i >= max) {
                System.out.println("Programme terminé.");
                sch.shutdown();
            }
        };
        sch.scheduleAtFixedRate(task,1,2, TimeUnit.SECONDS);*/

        }


}
