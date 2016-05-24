package com.dodevjutsu.katas.bank;

public class ConsoleStatementPrinter implements StatementPrinter {
    private final Format format;
    private final Console console;

    public ConsoleStatementPrinter(Format format, Console console) {
        this.format = format;
        this.console = console;
    }

    @Override
    public void print(Statement statement) {
        console.print(format.header());
    }
}
