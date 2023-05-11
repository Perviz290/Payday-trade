package com.neizu.paydaytrade.util;


import com.neizu.paydaytrade.dto.AccountDto;
import com.neizu.paydaytrade.dto.UserAccountDto;
import com.neizu.paydaytrade.dto.UserDto;
import com.neizu.paydaytrade.entity.Bank;
import com.neizu.paydaytrade.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final AccountConverter accountConverter;


    public UserDto converterUser(User user){
        UserDto userDto=UserDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .build();
        return userDto;
    }

    public UserAccountDto converterUserAccount(User user){
       List<AccountDto>accountDtoList =accountConverter.converterAccountList(user.getAccounts());
        UserAccountDto userAccountDto=UserAccountDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .accountList(accountDtoList)
                .build();
        return userAccountDto;
    }











}
