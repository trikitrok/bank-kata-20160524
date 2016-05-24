package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DateTest {

    private Date date;

    @Before
    public void setUp() {
        date = new Date("07/08/2009");
    }

    @Test
    public void provides_the_day() {
        assertThat(date.day(), is("07"));
    }

    @Test
    public void provides_the_month() {
        assertThat(date.month(), is("08"));
    }

    @Test
    public void provides_the_year() {
        assertThat(date.year(), is("2009"));
    }
}
