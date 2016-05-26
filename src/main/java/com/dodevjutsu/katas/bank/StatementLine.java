package com.dodevjutsu.katas.bank;

public class StatementLine {
    private final Date date;
    private final Amount amount;
    private final int balance;

    public StatementLine(Date date, int amount, int balance) {
        this.date = date;
        this.amount = new Amount(amount);
        this.balance = balance;
    }

    public boolean isCredit() {
        return amount.isCredit();
    }

    public boolean isDebit() {
        return amount.isDebit();
    }

    public Date date() {
        return date;
    }

    public int amount() {
        return amount.value();
    }

    public int balance() {
        return balance;
    }

    @Override
    public String toString() {
        return "StatementLine{" +
            "date=" + date +
            ", amount=" + amount +
            ", balance=" + balance +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatementLine)) return false;

        StatementLine that = (StatementLine) o;

        if (balance != that.balance) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + balance;
        return result;
    }
}
