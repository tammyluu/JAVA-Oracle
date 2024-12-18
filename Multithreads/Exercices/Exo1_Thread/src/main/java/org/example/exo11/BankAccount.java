package org.example.exo11;

public class BankAccount   {
    private double balance;

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " a déposé " + amount + ", solde actuel : " + balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " a retiré " + amount + ", solde actuel : " + balance);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " n'a pas pu retirer " + amount + " (solde insuffisant). Solde actuel : " + balance);
            return false;
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        Runnable deposit = ()->{
            for (int i = 0; i < 5; i++) {
                bankAccount.deposit(10);
            }
        };
        Runnable withdraw = ()->{
            for (int i = 0; i < 5; i++) {
                bankAccount.withdraw(10);
            }
        };
        Thread t1 = new Thread(deposit,"Thread-1 ");
        Thread t2 = new Thread(withdraw,"Thread-2 ");
        Thread t3 = new Thread(deposit,"Thread-3 ");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t3.join();
        t3.join();

        System.out.println("Solde final:  " + bankAccount.getBalance());
    }

}
