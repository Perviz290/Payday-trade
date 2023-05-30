package com.neizu.paydaytrade.service;
import com.neizu.paydaytrade.dto.FinanceStockDto;
import com.neizu.paydaytrade.entity.StockFinance;
import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.exception.FinanceStockNotFoundException;
import com.neizu.paydaytrade.exception.UsernameNotFoundException;
import com.neizu.paydaytrade.repository.FinanceStockRepo;
import com.neizu.paydaytrade.util.StockConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinanceApiService {

    private final FinanceStockRepo financeStockRepo;
    private final StockConverter converter;


    public List<FinanceStockDto> getAllFinanceStock() {
        return financeStockRepo.findAll()
                .stream()
                .map(converter :: converterStock)
                .collect(Collectors.toList());
    }


    public FinanceStockDto getFinanceByName(String name) {

        Optional<StockFinance> optional= financeStockRepo.findStockFinanceByName(name);
        if (optional.isEmpty()){
            throw new FinanceStockNotFoundException(name + "-This name is NotFound:::");
        }else {
            return converter.converterStock(optional.get());
        }
    }





}










