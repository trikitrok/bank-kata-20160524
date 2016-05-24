package com.dodevjutsu.katas.bank;

public class Account {
    private Transactions transactions;
    private StatementPrinter statementPrinter;

    public Account(Transactions transactions, StatementPrinter statementPrinter) {
        this.transactions = transactions;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactions.record(amount);
    }

    public void withdraw(int amount) {
        transactions.record(-amount);
    }

    public void printStatement() {
        Statement statement = transactions.statement();
        statementPrinter.print(statement);
    }
}
