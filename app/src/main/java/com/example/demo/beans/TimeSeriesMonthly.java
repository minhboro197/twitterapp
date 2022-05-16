package com.example.demo.beans;

import javax.persistence.*;

@Entity
public class TimeSeriesMonthly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Symbol symbol;

    private String year;
    private String month;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;

    public void setAll(String year, String month, String open, String high, String low, String close, String volume){
        this.year = year;
        this.month = month;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }


    public void setId(Integer id) { this.id = id; }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public Integer getId() {
        return id;
    }

    public String getOpen() {
        return open;
    }

    public String getClose() {
        return close;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getVolume() {
        return volume;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) { this.symbol = symbol; }

    public void setYear(String year) { this.year = year; }

    public void setMonth(String month) { this.month = month; }

    public void setOpen(String open) { this.open = open; }

    public void setHigh(String high) { this.high = high; }

    public void setLow(String low) { this.low = low; }

    public void setClose(String close) { this.close = close; }

    public void setVolume(String volume) { this.volume = volume; }
}
