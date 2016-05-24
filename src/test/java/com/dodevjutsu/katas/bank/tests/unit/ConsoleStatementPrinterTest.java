package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Console;
import com.dodevjutsu.katas.bank.ConsoleStatementPrinter;
import com.dodevjutsu.katas.bank.Format;
import com.dodevjutsu.katas.bank.StatementPrinter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

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
    public void prints_header_according_to_format() {
        String header = "date || credit || debit || balance";
        context.checking(new Expectations() {{
            oneOf(format).header();
            will(returnValue(header));

            oneOf(console).print(header);
            ignoring(console);
        }});

        statementPrinter.print(anyStatement());

        context.assertIsSatisfied();
    }
}
