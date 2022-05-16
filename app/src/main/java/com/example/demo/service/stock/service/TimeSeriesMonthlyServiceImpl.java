package com.example.demo.service.stock.service;

import com.example.demo.beans.Symbol;
import com.example.demo.beans.TimeSeriesMonthly;
import com.example.demo.repository.SymbolRepository;
import com.example.demo.repository.TimeSeriesMonthlyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TimeSeriesMonthlyServiceImpl implements TimeSeriesMonthlyService{
    @Autowired
    private TimeSeriesMonthlyRepository timeSeriesMonthlyRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final SymbolRepository symbolRepostory;

    public TimeSeriesMonthlyServiceImpl(TimeSeriesMonthlyRepository timeSeriesMonthlyRepository, SymbolRepository symbolRepostory) {
        this.timeSeriesMonthlyRepository = timeSeriesMonthlyRepository;
        this.symbolRepostory = symbolRepostory;
    }

    @Override
    public void saveTSM(TimeSeriesMonthly timeSeriesMonthly) {
        try {
            this.timeSeriesMonthlyRepository.save(timeSeriesMonthly);
            System.out.println("Year" + timeSeriesMonthly.getYear());
        } catch (Exception e) {
            logger.debug(e.toString());
        }

    }


    @Override
    public List<TimeSeriesMonthly> getAllTSM() { return this.timeSeriesMonthlyRepository.findAll(); }

    @Override
    public List<TimeSeriesMonthly> getTSMBySymbol(String symbol) {
        Symbol symbol1 = this.symbolRepostory.findBySymbol(symbol);
        return this.timeSeriesMonthlyRepository.findAllBySymbolId(symbol1.getId());
    }

    public TimeSeriesMonthly getTSM(Integer id) {
        TimeSeriesMonthly tsm = null;
        try {
            tsm = this.timeSeriesMonthlyRepository.findById(id)
                    .orElseThrow(() -> new Exception("Symbol not found for this id ::" + id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        assert tsm != null;
        System.out.println(tsm.toString());
        return tsm;
    }

    @Override
    public TimeSeriesMonthly deleteTSM(Integer id) {
        TimeSeriesMonthly tsm = getTSM(id);
        this.timeSeriesMonthlyRepository.delete(tsm);
        return tsm;
    }
}
