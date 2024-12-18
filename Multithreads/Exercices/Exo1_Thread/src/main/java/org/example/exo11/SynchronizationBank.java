package org.example.exo11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SynchronizationBank {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BankAccount account = new BankAccount();

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

            // Effectuer 5 retraits
            for (int i = 0; i < 5; i++) {
                BankOperation callable = new BankOperation(10, true, account);
                Future<Double> result = executor.submit(callable);
                try {
                   result.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            // Effectuer 5 dépôts
            for (int i = 0; i < 5; i++) {
                BankOperation callable = new BankOperation(10, false, account);
                Future<Double> result = executor.submit(callable);
                try {
                    result.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Solde final : " + account.getBalance());

    }
}



