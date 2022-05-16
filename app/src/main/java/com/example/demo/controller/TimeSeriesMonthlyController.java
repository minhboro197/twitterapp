package com.example.demo.controller;

import com.example.demo.service.stock.service.TimeSeriesMonthlyService;
import com.example.demo.beans.TimeSeriesMonthly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeSeriesMonthlyController {
    @Autowired
    private TimeSeriesMonthlyService timeSeriesMonthlyService;

    @RequestMapping(path = "/time_series_monthly",method = RequestMethod.GET)
    public List<TimeSeriesMonthly> getAllTSM(){
        return timeSeriesMonthlyService.getAllTSM();
    }

    @GetMapping("/time_series_monthly/{symbol}")
    public List<TimeSeriesMonthly> getTSMBySymbol(@PathVariable(value = "symbol") String symbol){
        return timeSeriesMonthlyService.getTSMBySymbol(symbol);
    }


    @RequestMapping(path = "/time_series_monthly", method = RequestMethod.POST)
    public void addTSM(@RequestBody TimeSeriesMonthly timeSeriesMonthly){
        System.out.println(timeSeriesMonthly.getYear()+ timeSeriesMonthly.getMonth()+timeSeriesMonthly.getHigh() +timeSeriesMonthly.getLow());
        timeSeriesMonthlyService.saveTSM(timeSeriesMonthly);
    }

    @RequestMapping(path = "/time_series_monthly", method = RequestMethod.PUT)
    public void updateTSM(@RequestBody TimeSeriesMonthly timeSeriesMonthly){
        timeSeriesMonthlyService.saveTSM(timeSeriesMonthly);
    }

//    @RequestMapping(path = "/time_series_monthly/{id}", method = RequestMethod.DELETE)
//    public void deleteTSM(@PathVariable(value = "id") Long id){
//        timeSeriesMonthlyService.deleteTSM(id);
//    }

//    @RequestMapping(path = "/time_series_monthly/{id}", method = RequestMethod.GET)
//    public TimeSeriesMonthly getTSM(@PathVariable(value = "id") Long id){
//        return timeSeriesMonthlyService.getTSM(id);
//    }
    @RequestMapping(path = "/time_series_monthly/{id}", method = RequestMethod.DELETE)
    public void deleteTSM(@PathVariable(value = "id") Integer id){
        timeSeriesMonthlyService.deleteTSM(id);
    }

    @RequestMapping(path = "/time_series_monthly/{id}", method = RequestMethod.GET)
    public TimeSeriesMonthly getTSM(@PathVariable(value = "id") Integer id){
        return timeSeriesMonthlyService.getTSM(id);
    }
}
