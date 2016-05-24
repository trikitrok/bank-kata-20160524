package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.InMemoryTransactions;
import com.dodevjutsu.katas.bank.Transactions;

public class InMemoryTransactionsTest extends TransactionsTest{
    @Override
    protected Transactions getImplementation() {
        return new InMemoryTransactions();
    }
}
