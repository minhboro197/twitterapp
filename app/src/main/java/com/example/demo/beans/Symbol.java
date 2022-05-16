package com.example.demo.beans;

import javax.persistence.*;

@Entity
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String symbol;
    private String name;
    private String description;
    private String CIK;
    private String exchange;
    private String country;
    private String sector;
    private String industry;
    private String address;

    public void setAll(String symbol, String name, String description, String CIK, String exchange, String country, String sector, String industry, String address){
        this.symbol = symbol;
        this.name = name;
        this.description = description;
        this.CIK = CIK;
        this.exchange = exchange;
        this.country = country;
        this.sector = sector;
        this.industry = industry;
        this.address = address;
    }


    public String getCIK() { return CIK; }

    public Integer getId() { return id; }

    public String getAddress() { return address; }

    public String getCountry() { return country; }

    public String getDescription() { return description; }

    public String getExchange() { return exchange; }

    public String getIndustry() { return industry; }

    public String getName() { return name; }

    public String getSector() { return sector; }

    public String getSymbol() { return symbol; }

    public void setId(Integer id) { this.id = id; }

    public void setDescription(String description) { this.description = description; }

    public void setExchange(String exchange) { this.exchange = exchange; }

    public void setIndustry(String industry) { this.industry = industry; }

    public void setName(String name) { this.name = name; }

    public void setSector(String sector) { this.sector = sector; }

    public void setSymbol(String symbol) { this.symbol = symbol; }

    public void setAddress(String address) { this.address = address; }

    public void setCIK(String CIK) { this.CIK = CIK; }

    public void setCountry(String country) { this.country = country; }
}
