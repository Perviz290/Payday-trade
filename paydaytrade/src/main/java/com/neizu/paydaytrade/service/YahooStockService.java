package com.neizu.paydaytrade.service;


import com.neizu.paydaytrade.dto.StockDto;
import com.neizu.paydaytrade.util.StockConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YahooStockService {

    private final StockConverter stockConverter;


    public StockDto getStock(String stockName) throws IOException {
        return stockConverter.converterStock(YahooFinance.get(stockName));
    }


    public List<HistoricalQuote> getAllStock(String stockName) throws IOException {
        return YahooFinance.get(stockName).getHistory();
    }
}
