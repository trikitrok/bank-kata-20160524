package com.dodevjutsu.katas.bank;

public class Date {
    private final String date;

    public Date(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date1 = (Date) o;

        return date != null ? date.equals(date1.date) : date1.date == null;
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Date{" +
            "date='" + date + '\'' +
            '}';
    }
}
