package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Account;
import com.dodevjutsu.katas.bank.StatementPrinter;
import com.dodevjutsu.katas.bank.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AccountTests {

    private Mockery context;
    private Transactions transactions;
    private StatementPrinter statementPrinter;
    private Account account;

    @Before
    public void setUp(){
        context = new Mockery();
        transactions = context.mock(Transactions.class);
        statementPrinter = context.mock(StatementPrinter.class);
        account =  new Account(transactions, statementPrinter);
    }

    @Test
    public void deposits_amount() {
        int amount = 100;
        context.checking(new Expectations() {{
            oneOf(transactions).record(amount);
        }});

        account.deposit(amount);

        context.assertIsSatisfied();
    }
}
