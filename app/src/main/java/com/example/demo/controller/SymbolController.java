package com.example.demo.controller;

import com.example.demo.beans.Symbol;
import com.example.demo.service.stock.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SymbolController {
    @Autowired
    private SymbolService symbolService;

    @RequestMapping(path = "/symbols",method = RequestMethod.GET)
    public List<Symbol> getAllSymbols(){
        return symbolService.getAllStudents();
    }

    @GetMapping("/symbols/{symbol}")
    public Symbol getSymbolBySymbol(@PathVariable(value = "symbol") String symbol){
        return symbolService.getSymbolBySymbol(symbol);
    }

    @PostMapping(path = "/symbols")
    public void addSymbol(@RequestBody Symbol symbol, Model model){
        model.addAttribute("symbol",symbol);
        symbolService.saveSymbol(symbol);
    }

    @RequestMapping(path = "/symbols", method = RequestMethod.PUT)
    public void updateSymbol(@RequestBody Symbol symbol){
        symbolService.saveSymbol(symbol);
    }

//    @RequestMapping(path = "/symbols/{id}", method = RequestMethod.DELETE)
//    public void deleteSymbol(@PathVariable(value = "id") Long id){
//        symbolService.deleteSymbol(id);
//    }

//    @RequestMapping(path = "/symbols/{id}", method = RequestMethod.GET)
//    public Symbol getSymbol(@PathVariable(value = "id") Long id){
//        return symbolService.getSymbol(id);
//    }
}
