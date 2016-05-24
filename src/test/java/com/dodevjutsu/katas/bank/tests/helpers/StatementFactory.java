package com.dodevjutsu.katas.bank.tests.helpers;

import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.StatementLine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StatementFactory {
    public static Statement anEmptyStatement() {
        return new Statement(Collections.emptyList());
    }

    public static Statement aStatementContainingLines(StatementLine... statementLines) {
        return new Statement(Arrays.asList(statementLines));
    }

    public static Statement anyStatement() {
        return anEmptyStatement();
    }

    public static Statement aStatementContainingLines(StatementLineBuilder... statementLineBuilders) {
        List<StatementLine> statementLines = buildStatementLinesUsing(statementLineBuilders);
        return new Statement(statementLines);
    }

    private static List<StatementLine> buildStatementLinesUsing(StatementLineBuilder[] statementLineBuilders) {
        return Arrays.asList(statementLineBuilders).stream()
            .map(builder -> builder.build())
            .collect(Collectors.toList());
    }
}
