package com.dodevjutsu.katas.bank.tests.helpers;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.StatementLine;

public class StatementLineBuilder {
    private Date on;
    private int amount;
    private int balance;

    public static StatementLineBuilder aStatementLine() {
        return new StatementLineBuilder();
    }

    public StatementLineBuilder on(Date date) {
        this.on = date;
        return this;
    }

    public StatementLineBuilder ofAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public StatementLineBuilder andBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public StatementLine build() {
        return new StatementLine(on, amount, balance);
    }

    public StatementLineBuilder on(String date) {
        this.on = new Date(date);
        return this;
    }
}
