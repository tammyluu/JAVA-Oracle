package org.example.exo11;

public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " a déposé " + amount + ", solde actuel : " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " a retiré " + amount + ", solde actuel : " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " n'a pas pu retirer " + amount + ", solde actuel : " + balance);

        }
    }

    public int getBalance() {
        return balance;
    }

}
