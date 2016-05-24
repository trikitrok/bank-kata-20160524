package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private final String header;
    private final List<StatementLine> statementLines;

    public Statement() {
        this.header = "date || credit || debit || balance";
        this.statementLines = new ArrayList<>();
    }

    public Statement(List<StatementLine> statementLines) {
        this.header = "date || credit || debit || balance";
        this.statementLines = statementLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statement)) return false;

        Statement statement = (Statement) o;

        if (header != null ? !header.equals(statement.header) : statement.header != null) return false;
        return statementLines != null ? statementLines.equals(statement.statementLines) : statement.statementLines == null;

    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (statementLines != null ? statementLines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Statement{" +
            "header='" + header + '\'' +
            ", statementLines=" + statementLines +
            '}';
    }
}
