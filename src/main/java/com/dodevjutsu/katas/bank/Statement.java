package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statement {
    private final List<StatementLine> statementLines;

    public Statement(List<StatementLine> statementLines) {
        this.statementLines = statementLines;
    }

    public void printLines(Format format, Console console) {
        statementLinesInReverseOrder().forEach(
            line -> console.print(format.formatLine(line))
        );
    }

    private List<StatementLine> statementLinesInReverseOrder() {
        List<StatementLine> reversed = new ArrayList<>(statementLines);
        Collections.reverse(reversed);
        return reversed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statement)) return false;

        Statement statement = (Statement) o;

        return statementLines != null ? statementLines.equals(statement.statementLines) : statement.statementLines == null;

    }

    @Override
    public int hashCode() {
        return statementLines != null ? statementLines.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Statement{" +
            "statementLines=" + statementLines +
            '}';
    }
}
