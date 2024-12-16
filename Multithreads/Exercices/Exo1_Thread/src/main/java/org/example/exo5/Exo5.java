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

        List<Future<Integer>> résultats = new ArrayList<>();

        try {

            for (int i = 1; i <= 10; i++) {
                Exo5 task= new Exo5(i);
                Future<Integer> futur = executor.submit(task) ;
                résultats.add(futur);
            }

            // Récupérer et afficher les résultats
            for (Future<Integer> futur : résultats) {
                System.out.println("Résultat de la tâche "+futur.get());
            }
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            // Arrête proprement l'ExecutorService
            executor.shutdown();
        }
    }



}
