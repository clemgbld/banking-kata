package bankingKata.core.entities;


import bankingKata.core.dateProvider.IDateProvider;

import java.text.SimpleDateFormat;


public class Transaction {
    private final IDateProvider dateProvider;
    private final double amount;

    private final boolean isDeposit;

    private final double balance;
    public Transaction(IDateProvider dateProvider,double amount,double balance,boolean isDeposit) {
        this.dateProvider = dateProvider;
        this.amount = amount;
        this.balance = balance;
        this.isDeposit = isDeposit;

    }

    public String getDate() {
        return getFormattedDate();
    }

    public String getAmount() {

        return isDeposit ? "+" + amount : "-" + amount ;
    }

    public double getBalance() {
        return balance;
    }

    private String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dateProvider.now());
    }
}
