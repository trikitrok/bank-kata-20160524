package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContainingLines;

public class ConsoleStatementPrinterTest {
    Mockery context;
    Format format;
    private Console console;
    private StatementPrinter statementPrinter;

    @Before
    public void setUp() {
        context = new Mockery();
        format = context.mock(Format.class);
        console = context.mock(Console.class);
        statementPrinter = new ConsoleStatementPrinter(format, console);
    }

    @Test
    public void prints_formatted_header_and_a_line_for_each_statement_line_in_reverse_order() {
        String header = "date || credit || debit || balance";
        String firstLine = "first line";
        String secondLine = "second line";
        final StatementLine secondStatementLine = new StatementLine(new Date("13/01/2012"), 2000, 3000);
        final StatementLine firstStatementLine = new StatementLine(new Date("10/01/2012"), 1000, 1000);
        context.checking(new Expectations() {{
            oneOf(format).header();
            will(returnValue(header));

            atLeast(1).of(format).formatLine(with(secondStatementLine));
            will(returnValue(firstLine));

            atLeast(1).of(format).formatLine(with(firstStatementLine));
            will(returnValue(secondLine));

            oneOf(console).print(header);
            oneOf(console).print(firstLine);
            oneOf(console).print(secondLine);
        }});

        statementPrinter.print(
            aStatementContainingLines(firstStatementLine, secondStatementLine)
        );

        context.assertIsSatisfied();
    }
}
