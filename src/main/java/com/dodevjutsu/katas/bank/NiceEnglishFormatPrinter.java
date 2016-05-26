package com.dodevjutsu.katas.bank;

import java.util.List;

public class NiceEnglishFormatPrinter implements StatementPrinter {
    private final Console console;

    public NiceEnglishFormatPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void print(Statement statement) {
        printHeader();
        printLines(statement.linesInReversedOrder());
    }

    private void printLines(List<StatementLine> lines) {
        lines.forEach(line -> console.print(formatLine(line)));
    }

    private void printHeader() {
        console.print("date || credit || debit || balance");
    }

    private String formatLine(StatementLine statementLine) {
        return String.format("%s||%s||%s||%s",
            dateFrom(statementLine),
            creditFrom(statementLine),
            debitFrom(statementLine),
            balanceFrom(statementLine));
    }

    private String dateFrom(StatementLine statementLine) {
        Date date = statementLine.date();
        return String.format("%s/%s/%s ", date.day(), date.month(), date.year());
    }

    private String creditFrom(StatementLine statementLine) {
        if (statementLine.isCredit()) {
            return String.format(" %s ", padWithTwoDecimals(statementLine.amount()));
        }
        return " ";
    }

    private String debitFrom(StatementLine statementLine) {
        if (statementLine.isDebit()) {
            return " " + padWithTwoDecimals(Math.abs(statementLine.amount())) + " ";
        }
        return " ";
    }

    private String balanceFrom(StatementLine statementLine) {
        return " " + padWithTwoDecimals(statementLine.balance());
    }

    private String padWithTwoDecimals(int number) {
        return number + ".00";
    }
}
