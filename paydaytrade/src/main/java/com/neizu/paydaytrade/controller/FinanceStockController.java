package com.neizu.paydaytrade.controller;
import com.neizu.paydaytrade.dto.FinanceStockDto;
import com.neizu.paydaytrade.service.FinanceApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/finance/stock")
public class FinanceStockController {


    private final FinanceApiService financeApiService;


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FinanceStockDto> getAllFinanceStock() {
        return financeApiService.getAllFinanceStock();
    }


    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public FinanceStockDto getFinanceByName(@RequestParam String name){
        return financeApiService.getFinanceByName(name);
    }






























}
