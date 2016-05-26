package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Console;
import com.dodevjutsu.katas.bank.Format;
import com.dodevjutsu.katas.bank.NiceEnglishFormat;
import com.dodevjutsu.katas.bank.StatementLine;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;

public class NiceEnglishFormatTest {
    private Mockery context;
    private Format format;
    private Console console;

    @Before
    public void setUp() {
        context = new Mockery();
        console = context.mock(Console.class);
        format = new NiceEnglishFormat();
    }

    @Test
    public void prints_a_formatted_header() {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
        }});

        format.printHeader(console);

        context.assertIsSatisfied();
    }

    @Test
    public void formats_a_credit_statement_line() {
        StatementLine statementLine = aStatementLine()
            .on("17/01/2016")
            .ofAmount(500)
            .andBalance(1500).build();

        context.checking(new Expectations() {{
            oneOf(console).print("17/01/2016 || 500.00 || || 1500.00");
        }});

        format.printLines(Arrays.asList(statementLine), console);

        context.assertIsSatisfied();
    }

    @Test
    public void formats_a_debit_statement_line() {
        StatementLine statementLine = aStatementLine()
            .on("17/01/2016")
            .ofAmount(-500)
            .andBalance(1500).build();

        context.checking(new Expectations() {{
            oneOf(console).print("17/01/2016 || || 500.00 || 1500.00");
        }});

        format.printLines(Arrays.asList(statementLine), console);

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_line_for_each_statement_line_in_reverse_order() {
        StatementLine firstStatementLine = aStatementLine()
            .on("10/01/2012")
            .ofAmount(1000)
            .andBalance(1000).build();
        StatementLine secondStatementLine = aStatementLine()
            .on("13/01/2012")
            .ofAmount(2000)
            .andBalance(3000).build();

        context.checking(new Expectations() {{
            oneOf(console).print("13/01/2012 || 2000.00 || || 3000.00");
            oneOf(console).print("10/01/2012 || 1000.00 || || 1000.00");
        }});

        format.printLines(
            Arrays.asList(firstStatementLine, secondStatementLine), console
        );

        context.assertIsSatisfied();
    }
}
