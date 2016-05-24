package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anEmptyStatement;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContainingLines;
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
        context.checking(new Expectations() {{
            exactly(2).of(clock).day();
            will(onConsecutiveCalls(
                returnValue(new Date("10/01/2012")),
                returnValue(new Date("14/01/2012"))
            ));
        }});
        transactions.record(1000);
        transactions.record(-500);

        assertThat(transactions.statement(),
            is(aStatementContainingLines(
                new StatementLine(new Date("10/01/2012"), 1000, 1000),
                new StatementLine(new Date("14/01/2012"), 500, 500)))
        );
    }

    protected abstract Transactions getImplementationUsingClock(Clock clock);
}
