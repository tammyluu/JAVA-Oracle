package org.example.exo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exo5 implements Callable<Integer> {
    private final int num;

    public Exo5(int num) {
        this.num = num;
    }


    @Override
    public Integer call() throws Exception {
        return num * num;
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        //Future<Integer>[] result = new Future[10];
        List<Future<Integer>> result = new ArrayList<>();

        try {

            for (int i = 1; i <= 10; i++) {
                Exo5 task= new Exo5(i);
                Future<Integer> future = executor.submit(task) ;
                result.add(future);
            }


            for (Future<Integer> future : result) {
                System.out.println("Résultat de la tâche "+future.get() +" est : " + future.resultNow());
            }
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }



}
