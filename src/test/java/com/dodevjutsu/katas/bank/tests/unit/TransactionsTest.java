package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.Transactions;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

abstract public class TransactionsTest {
    @Test
    public void when_no_transactions_were_recorded_an_empty_statement_is_produced() {
        Transactions transactions = getImplementation();

        assertThat(transactions.statement(), is(new Statement()));
    }

    protected abstract Transactions getImplementation();
}
