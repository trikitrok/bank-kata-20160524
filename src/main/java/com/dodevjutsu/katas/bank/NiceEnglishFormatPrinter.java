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
        int amount = statementLine.amount();
        if (isCredit(amount)) {
            return " " + padWithTwoDecimals(amount) + " ";
        }
        return " ";
    }

    private boolean isCredit(int amount) {
        return amount >= 0;
    }

    private String debitFrom(StatementLine statementLine) {
        int amount = statementLine.amount();
        if (isDebit(amount)) {
            return " " + padWithTwoDecimals(Math.abs(amount)) + " ";
        }
        return " ";
    }

    private boolean isDebit(int amount) {
        return amount < 0;
    }

    private String balanceFrom(StatementLine statementLine) {
        return " " + padWithTwoDecimals(statementLine.balance());
    }

    private String padWithTwoDecimals(int number) {
        return number + ".00";
    }
}
