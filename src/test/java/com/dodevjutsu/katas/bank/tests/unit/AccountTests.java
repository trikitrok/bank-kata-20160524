package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Account;
import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.StatementPrinter;
import com.dodevjutsu.katas.bank.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anyStatement;

public class AccountTests {

    private Mockery context;
    private Transactions transactions;
    private StatementPrinter statementPrinter;
    private Account account;
    final int ANY_AMOUNT = 500;

    @Before
    public void setUp() {
        context = new Mockery();
        transactions = context.mock(Transactions.class);
        statementPrinter = context.mock(StatementPrinter.class);
        account = new Account(transactions, statementPrinter);
    }

    @Test
    public void deposits_amount() {
        context.checking(new Expectations() {{
            oneOf(transactions).record(ANY_AMOUNT);
        }});

        account.deposit(ANY_AMOUNT);

        context.assertIsSatisfied();
    }

    @Test
    public void withdraws_amount() {
        context.checking(new Expectations() {{
            oneOf(transactions).record(-ANY_AMOUNT);
        }});

        account.withdraw(ANY_AMOUNT);

        context.assertIsSatisfied();
    }

    @Test
    public void a_statement_of_the_transactions_is_produced_in_order_to_print_it() {
        context.checking(new Expectations() {{
            ignoring(statementPrinter);
            oneOf(transactions).statement();
            will(returnValue(with(any(Statement.class))));
        }});

        account.printStatement();

        context.assertIsSatisfied();
    }

    @Test
    public void the_produced_statement_is_printed() {
        Statement producedStatement = anyStatement();
        context.checking(new Expectations() {{
            oneOf(transactions).statement();
            will(returnValue(producedStatement));
            oneOf(statementPrinter).print(with(same(producedStatement)));
        }});

        account.printStatement();

        context.assertIsSatisfied();
    }
}
