package com.example.demo.service.stock.service;

import com.example.demo.beans.Symbol;
import com.example.demo.repository.SymbolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SymbolServiceImpl implements SymbolService{

    @Autowired
    private SymbolRepository symbolRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void saveSymbol(Symbol symbol) {
        try {
            System.out.println(symbol.getName());
            if (symbolRepository == null)
                System.out.println("null");
            this.symbolRepository.save(symbol);
        } catch (Exception e) {
            logger.debug(e.toString());
        }
    }

    @Override
    public Symbol getSymbolBySymbol(String symbol) {
        return this.symbolRepository.findBySymbol(symbol);
    }


    @Override
    public List<Symbol> getAllStudents() { return this.symbolRepository.findAll(); }

    @Override
    public Symbol getSymbol(Integer id) {
        Symbol symbol = null;
        try {
            symbol = this.symbolRepository.findById(id)
                    .orElseThrow(() -> new Exception("Symbol not found for this id ::" + id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        assert symbol != null;
        System.out.println(symbol.toString());
        return symbol;
    }

    @Override
    public Symbol deleteSymbol(Integer id) {
        Symbol symbol = getSymbol(id);
        this.symbolRepository.delete(symbol);
        return symbol;
    }
}
