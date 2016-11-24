package com.dodevjutsu.katas.bank;

public class Date {
    private final String date;

    public Date(String date) {
        this.date = date;
    }

    public String day() {
        return date.substring(0, 2);
    }

    public String month() {
        return date.substring(3, 5);
    }

    public String year() {
        return date.substring(6, 10);
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

    public int compare(Date other) {
        int v1 = yearNumber() * 1000 +
            monthNumber(Date.this) * 100 +
            dayNumber(Date.this);
        int v2 = other.yearNumber() * 1000 +
            monthNumber(other) * 100 +
            dayNumber(other);

        if (v1 < v2) {
            return -1;
        } else if (v1 == v2) {
            return 0;
        } else {
            return 1;
        }
    }

    private int dayNumber(Date other) {
        return Integer.parseInt(other.day());
    }

    private int monthNumber(Date other) {
        return Integer.parseInt(other.month());
    }

    private int yearNumber() {
        return Integer.parseInt(year());
    }
}
