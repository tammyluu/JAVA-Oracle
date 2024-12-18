package org.example.exo11;

import java.util.concurrent.Callable;

public class BankOperation implements Callable<Double> {
    private final double amount;
    private final boolean isWithdrawal; // true pour retrait, false pour dépôt
    private final BankAccount account;

    public BankOperation(double amount, boolean isWithdrawal, BankAccount account) {
        this.amount = amount;
        this.isWithdrawal = isWithdrawal;
        this.account = account;
    }

    @Override
    public Double call() {
        if (isWithdrawal) {
            account.withdraw(amount);
        } else {
            account.deposit(amount);
        }
        return account.getBalance();

    }
}
