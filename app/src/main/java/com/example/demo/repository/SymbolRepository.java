package com.example.demo.repository;

import com.example.demo.beans.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymbolRepository extends JpaRepository<Symbol, Integer> {
    Symbol findBySymbol(String symbol);
}
