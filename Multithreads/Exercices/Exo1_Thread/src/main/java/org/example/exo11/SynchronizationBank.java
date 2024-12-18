package org.example.exo11;

import java.util.concurrent.*;

public class SynchronizationBank {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BankAccount account = new BankAccount();

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

            BankAccount myBankAccount = new BankAccount();


            // Soumettre 5 tâches de retrait
            for (int i = 0; i < 5; i++) {
                BankOperation callable = new BankOperation(10, true, myBankAccount);
                executor.submit(callable);
            }

            // Soumettre 5 tâches de dépôt
            for (int i = 0; i < 5; i++) {
                BankOperation callable = new BankOperation(10, false, myBankAccount);
                executor.submit(callable);
            }

            executor.shutdown();

            try {
                // Attendre la terminaison de toutes les tâches (maximum 10 secondes)
                if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                    System.out.println("Les tâches n'ont pas été terminées dans le délai imparti.");
                }
            } catch (InterruptedException e) {
                System.err.println("Le thread principal a été interrompu pendant l'attente.");
            }

            System.out.println("Solde final : " + myBankAccount.getBalance());
        }

    }
}



