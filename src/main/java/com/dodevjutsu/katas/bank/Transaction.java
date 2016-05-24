package com.dodevjutsu.katas.bank;

public class Transaction {
    private final int amount;
    private final Date day;

    public Transaction(int amount, Date day) {
        this.amount = amount;
        this.day = day;
    }

    public StatementLine generateStatementLine(int accumulatedBalance) {
        return new StatementLine(day, Math.abs(amount), amount + accumulatedBalance);
    }
}
