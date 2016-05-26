package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Console;
import com.dodevjutsu.katas.bank.NiceEnglishFormatPrinter;
import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.StatementPrinter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContainingLines;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anEmptyStatement;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;

public class NiceEnglishFormatTest {
    private Mockery context;
    private StatementPrinter printer;
    private Console console;

    @Before
    public void setUp() {
        context = new Mockery();
        console = context.mock(Console.class);
        printer = new NiceEnglishFormatPrinter(console);
    }

    @Test
    public void prints_an_empty_formatted_header() {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
        }});

        printer.print(anEmptyStatement());

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_statement_with_a_credit_statement_line() {
        Statement statement = aStatementContainingLines(
            aStatementLine()
                .on("10/01/2012")
                .ofAmount(1500)
                .andBalance(1500));

        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("10/01/2012 || 1500.00 || || 1500.00");
        }});

        printer.print(statement);

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_statement_with_a_debit_statement_line() {
        Statement statement = aStatementContainingLines(
            aStatementLine()
                .on("13/01/2012")
                .ofAmount(-500)
                .andBalance(0));

        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("13/01/2012 || || 500.00 || 0.00");
        }});

        printer.print(statement);

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_line_for_each_statement_line_in_reverse_order() {
        Statement statement = aStatementContainingLines(
            aStatementLine()
                .on("10/01/2012")
                .ofAmount(1500)
                .andBalance(1500),
            aStatementLine()
                .on("13/01/2012")
                .ofAmount(-500)
                .andBalance(1000));

        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("13/01/2012 || || 500.00 || 1000.00");
            oneOf(console).print("10/01/2012 || 1500.00 || || 1500.00");
        }});

        printer.print(statement);

        context.assertIsSatisfied();
    }
}
