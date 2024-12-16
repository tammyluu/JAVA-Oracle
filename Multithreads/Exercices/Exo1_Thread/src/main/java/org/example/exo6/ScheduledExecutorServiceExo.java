package org.example.exo6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExo {
    public static void main(String[] args) {

        scheduledExecutorServiceExo6();
    }

    public static void  scheduledExecutorServiceExo6() {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        ses.schedule( ()-> System.out.println("Tâche exécutée apès 1 seconds: "), 1, TimeUnit.SECONDS);


    }
}

