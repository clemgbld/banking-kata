package bankingKata.core.useCases;

import bankingKata.core.dateProvider.IDateProvider;
import bankingKata.core.entities.Transaction;
import bankingKata.core.logger.ILogger;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final ILogger logger;

    private final IDateProvider dateProvider;
    private final List<Transaction> transactions = new ArrayList<>();

    private double currentBalance;
    public Account(ILogger logger, IDateProvider dateProvider) {
        this.logger = logger;
        this.dateProvider = dateProvider;
    }

    public void printStatement() {
        String transactionsToPrint = transactions.stream()
                        .map(this::buildTransactionsToPrint)
                        .reduce("Date         Amount        Balance", String::concat);

        logger.log(transactionsToPrint);
    }

    private String buildTransactionsToPrint(Transaction transaction) {
        return "\n" + transaction.getDate() + "     " + transaction.getAmount() + "         " + transaction.getBalance();
    }

    public void deposit(double money) {
        currentBalance += money;
        performTransaction(money,true);
    }

    public void withdraw(double money) {
        currentBalance -= money;
        performTransaction(money,false);
    }

    private void performTransaction(double money, boolean isDeposit){
        Transaction transaction = new Transaction(dateProvider,money,currentBalance,isDeposit);
        transactions.add(0,transaction);
    }
}
