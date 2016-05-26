package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NiceEnglishFormat implements Format {
    @Override
    public void printHeader(Console console) {
        console.print("date || credit || debit || balance");
    }

    @Override
    public void printLines(List<StatementLine> statementLines, Console console) {
        List<StatementLine> reversed = new ArrayList<>(statementLines);
        Collections.reverse(reversed);
        reversed.forEach(statementLine -> console.print(formatLine(statementLine)));
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
        if (amount >= 0) {
            return " " + padWithTwoDecimals(amount) + " ";
        }
        return " ";
    }

    private String debitFrom(StatementLine statementLine) {
        int amount = statementLine.amount();
        if (amount < 0) {
            return " " + padWithTwoDecimals(Math.abs(amount)) + " ";
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
