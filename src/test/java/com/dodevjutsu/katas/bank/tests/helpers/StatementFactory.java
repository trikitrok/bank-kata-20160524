package com.dodevjutsu.katas.bank.tests.helpers;

import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.StatementLine;

import java.util.Arrays;
import java.util.Collections;

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
}
