package com.neizu.paydaytrade.dto.request;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BuyUserStockRequest {

    private String stockName;
    private BigDecimal targetPrice;
    private Integer userId;
    private String cardNumber;






}
