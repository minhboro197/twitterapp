package com.example.demo.service.stock.service;

import com.example.demo.beans.TimeSeriesMonthly;

import java.util.List;

public interface TimeSeriesMonthlyService {
    public void saveTSM(TimeSeriesMonthly timeSeriesMonthly);
    public List<TimeSeriesMonthly> getAllTSM();
    public List<TimeSeriesMonthly> getTSMBySymbol(String symbol);
    public TimeSeriesMonthly getTSM(Integer id);
    public TimeSeriesMonthly deleteTSM(Integer id);
}
