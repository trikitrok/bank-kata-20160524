package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anStatementContainingLines;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anyStatement;

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
        StatementLine firstStatementLine = new StatementLine(new Date("07/01/2016"), 200, 200);
        StatementLine secondStatementLine = new StatementLine(new Date("14/01/2016"), 800, 1000);
        String header = "date || credit || debit || balance";
        String firstFormattedStatementLine = "14/01/2016 || 800.00 || || 1000.00";
        String secondFormattedStatementLine = "07/01/2016 || 200.00 || || 200.00";
        context.checking(new Expectations() {{
            oneOf(format).header();
            will(returnValue(header));
            oneOf(format).formatLine(secondStatementLine);
            will(returnValue(firstFormattedStatementLine));
            oneOf(format).formatLine(firstStatementLine);
            will(returnValue(secondFormattedStatementLine));

            oneOf(console).print(header);
            oneOf(console).print(firstFormattedStatementLine);
            oneOf(console).print(secondFormattedStatementLine);
        }});

        statementPrinter.print(anStatementContainingLines(
            firstStatementLine, secondStatementLine
        ));

        context.assertIsSatisfied();
    }
}
