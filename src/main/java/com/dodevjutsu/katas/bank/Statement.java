package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Statement {
    private final List<StatementLine> statementLines;

    public Statement(List<StatementLine> statementLines) {
        this.statementLines = statementLines;
    }

    public void printLines(Format format, Console console) {
        statementLinesSortedByDateInDescOrder().forEach(
            line -> console.print(format.formatLine(line))
        );
    }

    private List<StatementLine> statementLinesSortedByDateInDescOrder() {
        List<StatementLine> statementLinesSortedByDateInDescOrder = new ArrayList<>(this.statementLines);
        Collections.sort(
            statementLinesSortedByDateInDescOrder,
            new DescDateComparator()
        );
        return statementLinesSortedByDateInDescOrder;
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

    private class DescDateComparator implements Comparator<StatementLine> {
        @Override
        public int compare(StatementLine one, StatementLine another) {
            return -one.date().compare(another.date());
        }
    }
}
