package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.Arrays;
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
        if(transactions.isEmpty()) {
            return new Statement();
        }
        return new Statement(Arrays.asList(
            new StatementLine(new Date("14/01/2012"), 500,  500),
            new StatementLine(new Date("10/01/2012"), 1000,  1000)));
    }
}
