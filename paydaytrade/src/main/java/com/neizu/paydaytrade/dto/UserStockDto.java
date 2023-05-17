package com.neizu.paydaytrade.dto;


import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.entity.UserStock;
import com.neizu.paydaytrade.util.UserConverter;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStockDto {

    private String stockName;
    private Double stockPrice;
    private UserDto user;


}
