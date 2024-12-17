package org.example.exo11;

public class SynchronizationBank {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Thread pour effectuer des retraits
        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(10);
                try {
                    Thread.sleep(100); // Pause pour simuler un traitement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        // Thread pour effectuer des dépôts (1)
        Thread depositThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(10);
                try {
                    Thread.sleep(50); // Pause pour simuler un traitement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        // Thread pour effectuer des dépôts (2)
        Thread depositThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(10);
                try {
                    Thread.sleep(70); // Pause pour simuler un traitement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-3");

        // Démarrage des threads
        withdrawThread.start();
        depositThread1.start();
        depositThread2.start();

        // Attente que tous les threads terminent
        try {
            withdrawThread.join();
            depositThread1.join();
            depositThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Affichage du solde final
        System.out.println("Solde final : " + account.getBalance());
    }
     private static Thread[] createThreads( Runnable task) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
        }
        return threads;
     }
     private static void runThreads( Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
     }
}
