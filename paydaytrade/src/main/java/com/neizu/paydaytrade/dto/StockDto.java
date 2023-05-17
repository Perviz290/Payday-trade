package com.neizu.paydaytrade.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class StockDto {

    private String name;
    private BigDecimal price;
    private BigDecimal change;
    private String currency;
    private BigDecimal bid;

}



