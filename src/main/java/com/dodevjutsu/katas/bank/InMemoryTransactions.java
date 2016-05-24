package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactions implements Transactions {
    private final Clock clock;
    private List<Transaction> transactions;

    public InMemoryTransactions(Clock clock) {
        this.clock = clock;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void record(int amount) {
        transactions.add(new Transaction(amount, clock.day()));
    }

    @Override
    public Statement statement() {
        List<StatementLine> statementLines = new ArrayList<>();
        int accumulatedBalance = 0;
        for (Transaction transaction : transactions) {
            statementLines.add(transaction.generateStatementLine(accumulatedBalance));
            accumulatedBalance += transaction.amount();
        }
        return new Statement(statementLines);
    }
}
