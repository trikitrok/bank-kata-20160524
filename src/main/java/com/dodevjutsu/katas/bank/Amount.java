package com.dodevjutsu.katas.bank;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public boolean isCredit() {
        return amount >= 0;
    }

    public int value() {
        return amount;
    }

    public boolean isDebit() {
        return !isCredit();
    }

    @Override
    public String toString() {
        return "Amount{" +
            "amount=" + amount +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amount)) return false;

        Amount amount1 = (Amount) o;

        return amount == amount1.amount;

    }

    @Override
    public int hashCode() {
        return amount;
    }
}
