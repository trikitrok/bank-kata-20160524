package com.dodevjutsu.katas.bank;

import java.util.List;

public interface Format {
    void printHeader(Console console);

    void printLines(List<StatementLine> statementLines, Console console);
}
