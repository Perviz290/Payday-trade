package com.neizu.paydaytrade.util;


import com.neizu.paydaytrade.dto.StockDto;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;

@Component
public class StockConverter {

    public StockDto converterStock(Stock stock){
        StockDto stockDto=StockDto.builder()
                .name(stock.getName())
                .price(stock.getQuote().getPrice())
                .bid(stock.getQuote().getBid())
                .currency(stock.getCurrency())
                .change(stock.getQuote().getChange())
                .build();
        return stockDto;
    }
}
