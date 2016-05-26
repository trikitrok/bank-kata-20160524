package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContainingLines;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;

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
        StatementLine firstStatementLine = aStatementLine()
            .on("10/01/2012")
            .ofAmount(1000)
            .andBalance(1000).build();
        StatementLine secondStatementLine = aStatementLine()
            .on("13/01/2012")
            .ofAmount(2000)
            .andBalance(3000).build();

        context.checking(new Expectations() {{
            oneOf(format).printHeader(console);
            oneOf(format).printLines(
                Arrays.asList(firstStatementLine, secondStatementLine),
                console
            );
        }});

        statementPrinter.print(
            aStatementContainingLines(firstStatementLine, secondStatementLine)
        );

        context.assertIsSatisfied();
    }
}
