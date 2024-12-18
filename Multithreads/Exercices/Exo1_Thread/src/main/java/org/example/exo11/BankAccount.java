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

}
