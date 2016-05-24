package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.StatementLine;
import com.dodevjutsu.katas.bank.Transaction;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TransactionTest {
    @Test
    public void generates_a_statement_line() {
        Transaction transaction = new Transaction(-3000, new Date("15/01/2015"));

        assertThat(
            transaction.generateStatementLine(5000),
            is(new StatementLine(new Date("15/01/2015"), 3000, 2000))
        );
    }
}
