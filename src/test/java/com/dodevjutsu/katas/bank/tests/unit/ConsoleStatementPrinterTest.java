package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContainingLines;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;

public class ConsoleStatementPrinterTest {
    private Mockery context;
    private Format format;
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
        Sequence statementLinesSequence = context.sequence("PrintsSequence");
        String header = "date || credit || debit || balance";
        String firstLine = "first line";
        String secondLine = "second line";
        StatementLine firstStatementLine = aStatementLine()
            .on("10/01/2012")
            .ofAmount(1000)
            .andBalance(1000).build();
        StatementLine secondStatementLine = aStatementLine()
            .on("13/01/2012")
            .ofAmount(2000)
            .andBalance(3000).build();

        context.checking(new Expectations() {{
            oneOf(format).header();
            will(returnValue(header));

            oneOf(format).formatLine(with(secondStatementLine));
            will(returnValue(firstLine));

            oneOf(format).formatLine(with(firstStatementLine));
            will(returnValue(secondLine));

            oneOf(console).print(header);
            inSequence(statementLinesSequence);
            oneOf(console).print(firstLine);
            inSequence(statementLinesSequence);
            oneOf(console).print(secondLine);
            inSequence(statementLinesSequence);
        }});

        statementPrinter.print(
            aStatementContainingLines(firstStatementLine, secondStatementLine)
        );

        context.assertIsSatisfied();
    }
}
