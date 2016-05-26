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

    private void printLines(List<StatementLine> statementLines) {
        statementLines.stream()
            .map(statementLine -> NiceEnglishFormat.format(statementLine))
            .forEach(line -> console.print(line));
    }

    private void printHeader() {
        console.print(NiceEnglishFormat.header());
    }

    private static class NiceEnglishFormat {
        static String format(StatementLine statementLine) {
            return String.format("%s||%s||%s||%s",
                dateFrom(statementLine),
                creditFrom(statementLine),
                debitFrom(statementLine),
                balanceFrom(statementLine));
        }

        static String header() {
            return "date || credit || debit || balance";
        }

        private static String dateFrom(StatementLine statementLine) {
            Date date = statementLine.date();
            return String.format("%s/%s/%s ", date.day(), date.month(), date.year());
        }

        private static String creditFrom(StatementLine statementLine) {
            if (statementLine.isCredit()) {
                return String.format(" %s ", padWithTwoDecimals(statementLine.amount()));
            }
            return " ";
        }

        private static String debitFrom(StatementLine statementLine) {
            if (statementLine.isDebit()) {
                return " " + padWithTwoDecimals(Math.abs(statementLine.amount())) + " ";
            }
            return " ";
        }

        private static String balanceFrom(StatementLine statementLine) {
            return " " + padWithTwoDecimals(statementLine.balance());
        }

        private static String padWithTwoDecimals(int number) {
            return number + ".00";
        }
    }
}
