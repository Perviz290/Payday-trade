package com.neizu.paydaytrade.util;


import com.neizu.paydaytrade.dto.FinanceStockDto;
import com.neizu.paydaytrade.entity.StockFinance;
import org.springframework.stereotype.Component;

@Component
public class StockConverter {

    public FinanceStockDto converterStock(StockFinance stock){
        FinanceStockDto stockDto= FinanceStockDto.builder()
                .name(stock.getName())
                .price(stock.getPrice())
                .change(stock.getChanged())
                .build();
        return stockDto;
    }
}
