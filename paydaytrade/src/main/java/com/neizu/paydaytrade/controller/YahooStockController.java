package com.neizu.paydaytrade.controller;

import com.neizu.paydaytrade.dto.StockDto;
import com.neizu.paydaytrade.service.YahooStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yahoofinance.histquotes.HistoricalQuote;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yahoo/stocks")
public class YahooStockController {


    private final YahooStockService yahooStockService;


    @GetMapping("/{stockName}")
    public StockDto getStock(@PathVariable String stockName) throws IOException {
        return yahooStockService.getStock(stockName);
    }


    @GetMapping("/all")
    public List<HistoricalQuote> getAllStock(@RequestParam String stockName) throws IOException {
        return yahooStockService.getAllStock(stockName);
    }






















}
