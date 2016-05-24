package com.dodevjutsu.katas.bank;

public class Statement {
    private final String header;

    public Statement() {
        this.header = "date || credit || debit || balance";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statement)) return false;

        Statement statement = (Statement) o;

        return header != null ? header.equals(statement.header) : statement.header == null;
    }

    @Override
    public int hashCode() {
        return header != null ? header.hashCode() : 0;
    }
}
