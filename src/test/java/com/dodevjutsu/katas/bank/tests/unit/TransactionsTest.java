package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Clock;
import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContainingLines;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anEmptyStatement;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

abstract public class TransactionsTest {

    private Clock clock;
    private Mockery context;
    private Transactions transactions;

    @Before
    public void setUp() {
        context = new Mockery();
        clock = context.mock(Clock.class);
        transactions = getImplementationUsingClock(clock);
    }

    @Test
    public void when_no_transactions_were_recorded_an_empty_statement_is_produced() {
        assertThat(transactions.statement(), is(anEmptyStatement()));
    }

    @Test
    public void when_transactions_are_recorded_the_statement_contains_them() {
        Date firstTransactionDate = new Date("10/01/2012");
        Date secondTransactionDate = new Date("14/01/2012");

        context.checking(new Expectations() {{
            exactly(2).of(clock).day();
            will(onConsecutiveCalls(
                returnValue(firstTransactionDate),
                returnValue(secondTransactionDate)
            ));
        }});
        transactions.record(1000);
        transactions.record(-500);

        assertThat(transactions.statement(),
            is(aStatementContainingLines(
                aStatementLine().on(firstTransactionDate).ofAmount(1000).andBalance(1000),
                aStatementLine().on(secondTransactionDate).ofAmount(-500).andBalance(500)))
        );
    }

    protected abstract Transactions getImplementationUsingClock(Clock clock);
}
