package com.example.demo.repository;

import com.example.demo.beans.TimeSeriesMonthly;
import com.example.demo.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeSeriesMonthlyRepository extends JpaRepository<TimeSeriesMonthly, Integer> {
    @Query(value ="SELECT * FROM time_series_monthly WHERE symbol_id = ?1 ORDER BY year asc, month asc", nativeQuery = true)
    List<TimeSeriesMonthly> findAllBySymbolId(Integer symbol);
    @Query("select t from TimeSeriesMonthly t where t.symbol = :symbol")
    public TimeSeriesMonthly searchBySymbol(@Param("symbol") String symbol);

}
