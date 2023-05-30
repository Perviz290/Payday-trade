package com.neizu.paydaytrade.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinanceStockDto {

    private String name;
    private BigDecimal price;
    private BigDecimal change;




}




