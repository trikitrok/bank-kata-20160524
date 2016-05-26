package com.dodevjutsu.katas.bank;

public class StatementLine {
    private final Date date;
    private final int amount;
    private final int balance;

    public StatementLine(Date date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Date date() {
        return date;
    }

    public int amount() {
        return amount;
    }

    public int balance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatementLine)) return false;

        StatementLine that = (StatementLine) o;

        if (amount != that.amount) return false;
        if (balance != that.balance) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + amount;
        result = 31 * result + balance;
        return result;
    }

    @Override
    public String toString() {
        return "StatementLine{" +
            "date=" + date +
            ", amount=" + amount +
            ", balance=" + balance +
            '}';
    }
}
