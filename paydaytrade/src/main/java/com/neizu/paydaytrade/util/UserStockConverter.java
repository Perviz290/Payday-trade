package com.neizu.paydaytrade.util;


import com.neizu.paydaytrade.dto.UserDto;
import com.neizu.paydaytrade.dto.UserStockDto;
import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.entity.UserStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStockConverter {

    private final UserConverter userConverter;

    public UserStockDto converter(UserStock userStock){
        UserDto userDto =userConverter.converterUser(userStock.getUser());
        UserStockDto userStockDto=UserStockDto.builder()
                .stockName(userStock.getStockName())
                .stockPrice(userStock.getStockPrice())
                .user(userDto)
                .build();
        return userStockDto;
    }







}
