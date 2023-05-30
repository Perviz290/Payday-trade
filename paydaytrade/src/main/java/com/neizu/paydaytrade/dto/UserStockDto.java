package com.neizu.paydaytrade.dto;


import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.entity.UserStock;
import com.neizu.paydaytrade.util.UserConverter;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStockDto {

    private String stockName;
    private BigDecimal stockPrice;
    private UserDto user;


}
