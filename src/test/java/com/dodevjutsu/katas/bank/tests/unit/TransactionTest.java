package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.Transaction;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TransactionTest {
    @Test
    public void generates_a_statement_line() {
        Date date = new Date("15/01/2015");
        int amount = -3000;
        int expectedBalance = 2000;
        int accumulatedBalance = 5000;
        Transaction transaction = new Transaction(amount, date);

        assertThat(
            transaction.generateStatementLine(accumulatedBalance),
            is(aStatementLine()
                .on(date)
                .ofAmount(amount)
                .andBalance(expectedBalance).build()
            )
        );
    }
}
