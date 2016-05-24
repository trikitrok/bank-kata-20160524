package com.dodevjutsu.katas.bank;

public class InMemoryTransactions implements Transactions {
    @Override
    public void record(int amount) {

    }

    @Override
    public Statement statement() {
        return new Statement();
    }
}
