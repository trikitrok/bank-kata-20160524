package com.dodevjutsu.katas.bank.tests.acceptance;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class PrintingAccountStatementTest {

    private Mockery context;
    private Console console;
    private Clock clock;
    private Account account;

    @Before
    public void setUp() {
        context = new Mockery();
        console = context.mock(Console.class);
        clock = context.mock(Clock.class);
        account = new Account(
            new InMemoryTransactions(clock),
            new ConsoleStatementPrinter(
                new NiceEnglishFormat(),
                console
            )
        );
    }

    @Test
    public void printing_statement_including_deposit_and_withdrawal() {
        context.checking(new Expectations() {{
            exactly(3).of(clock).day();
            will(onConsecutiveCalls(
                returnValue(new Date("10/01/2012")),
                returnValue(new Date("13/01/2012")),
                returnValue(new Date("14/01/2012"))
            ));
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("14/01/2012 || || 500.00 || 2500.00");
            oneOf(console).print("13/01/2012 || 2000.00 || || 3000.00");
            oneOf(console).print("10/01/2012 || 1000.00 || || 1000.00");
        }});

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();

        context.assertIsSatisfied();
    }
}
