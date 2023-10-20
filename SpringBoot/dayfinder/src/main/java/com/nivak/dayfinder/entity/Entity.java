package com.nivak.dayfinder.entity;

public class Entity {
    private int date;
    private String month;
    private int year;
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "data [date=" + date + ", month=" + month + ", year=" + year + "]";
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
