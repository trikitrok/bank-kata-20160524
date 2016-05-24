package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DateTest {

    @Test
    public void provides_the_day() {
        Date date = new Date("07/08/2009");

        assertThat(date.day(), is("07"));
    }

    @Test
    public void provides_the_month() {
        Date date = new Date("07/08/2009");

        assertThat(date.month(), is("08"));
    }

    @Test
    public void provides_the_year() {
        Date date = new Date("07/08/2009");

        assertThat(date.year(), is("2009"));
    }
}
