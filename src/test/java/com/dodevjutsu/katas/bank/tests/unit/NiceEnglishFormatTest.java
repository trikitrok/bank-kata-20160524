package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.Format;
import com.dodevjutsu.katas.bank.NiceEnglishFormat;
import com.dodevjutsu.katas.bank.StatementLine;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NiceEnglishFormatTest {
    @Test
    public void provides_a_formatted_header() {
        Format format = new NiceEnglishFormat();

        assertThat(format.header(), is("date || credit || debit || balance"));
    }

    @Test
    public void formats_a_statement_line() {
        Format format = new NiceEnglishFormat();

        assertThat(
            format.formatLine(new StatementLine(new Date("17/01/2016"), 500, 1500)),
            is("17/01/2016 || 500.00 || || 1500.00"));
    }
}
