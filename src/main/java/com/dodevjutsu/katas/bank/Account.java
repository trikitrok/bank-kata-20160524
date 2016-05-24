package com.dodevjutsu.katas.bank;

public class Account {
    private Transactions transactions;
    private StatementPrinter statementPrinter;

    public Account(Console console, Clock clock) {
    }

    public Account(Transactions transactions, StatementPrinter statementPrinter) {
        this.transactions = transactions;
    }

    public void deposit(int amount) {
        transactions.record(amount);
    }

    public void withdraw(int amount) {
        transactions.record(-amount);
    }

    public void printStatement() {

    }
}
