package com.neizu.paydaytrade.repository;

import com.neizu.paydaytrade.entity.StockFinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinanceStockRepo extends JpaRepository<StockFinance,Integer> {


    Optional<StockFinance> findStockFinanceByName(String name);
}
