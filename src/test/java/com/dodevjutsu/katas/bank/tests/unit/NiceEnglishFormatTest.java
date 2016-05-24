package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.Format;
import com.dodevjutsu.katas.bank.NiceEnglishFormat;
import com.dodevjutsu.katas.bank.StatementLine;
import org.junit.Before;
import org.junit.Test;

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
        assertThat(
            format.formatLine(new StatementLine(new Date("17/01/2016"), 500, 1500)),
            is("17/01/2016 || 500.00 || || 1500.00")
        );
    }

    @Test
    public void formats_a_debit_statement_line() {
        assertThat(
            format.formatLine(new StatementLine(new Date("17/01/2016"), -500, 1500)),
            is("17/01/2016 || || 500.00 || 1500.00")
        );
    }
}
