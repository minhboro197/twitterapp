package com.example.demo.service.stock.service;

import com.example.demo.beans.Symbol;

import java.util.List;

public interface SymbolService {
    public void saveSymbol(Symbol symbol);
    public Symbol getSymbolBySymbol(String symbol);
    public List<Symbol> getAllStudents();
    public Symbol getSymbol(Integer id);
    public Symbol deleteSymbol(Integer id);
}
