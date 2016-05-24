package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Format;
import com.dodevjutsu.katas.bank.NiceEnglishFormat;
import com.dodevjutsu.katas.bank.StatementLine;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NiceEnglishFormatTest {
    Format format;

    @Before
    public void setUp() {
        format = new NiceEnglishFormat();
    }

    @Test
    public void provides_a_formatted_header() {
        assertThat(format.header(), is("date || credit || debit || balance"));
    }

    @Test
    public void formats_a_credit_statement_line() {
        StatementLine statementLine = aStatementLine()
            .on("17/01/2016")
            .ofAmount(500)
            .andBalance(1500).build();

        assertThat(
            format.formatLine(statementLine),
            is("17/01/2016 || 500.00 || || 1500.00")
        );
    }

    @Test
    public void formats_a_debit_statement_line() {
        StatementLine statementLine = aStatementLine()
            .on("17/01/2016")
            .ofAmount(-500)
            .andBalance(1500).build();

        assertThat(
            format.formatLine(statementLine),
            is("17/01/2016 || || 500.00 || 1500.00")
        );
    }
}
