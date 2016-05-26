package com.dodevjutsu.katas.bank;

public class NiceEnglishFormat implements Format {
    @Override
    public String header() {
        return "date || credit || debit || balance";
    }

    @Override
    public String formatLine(StatementLine statementLine) {
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
            return String.format(" %s ", padWithTwoDecimals(Math.abs(statementLine.amount())));
        }
        return " ";
    }

    private String balanceFrom(StatementLine statementLine) {
        return String.format(" %s", padWithTwoDecimals(statementLine.balance()));
    }

    private String padWithTwoDecimals(int number) {
        return String.format("%d.00", number);
    }
}
