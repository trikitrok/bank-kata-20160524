package com.dodevjutsu.katas.bank;

public class Account {
    private Transactions transactions;
    private StatementPrinter printer;

    public Account(Transactions transactions, StatementPrinter statementPrinter) {
        this.transactions = transactions;
        this.printer = statementPrinter;
    }

    public void deposit(int amount) {
        transactions.record(amount);
    }

    public void withdraw(int amount) {
        transactions.record(-amount);
    }

    public void printStatement() {
        printer.print(transactions.statement());
    }
}
