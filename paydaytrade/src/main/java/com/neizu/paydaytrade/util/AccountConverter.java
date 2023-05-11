package com.neizu.paydaytrade.util;

import com.neizu.paydaytrade.dto.AccountDto;
import com.neizu.paydaytrade.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountConverter {


    public AccountDto converterAccount(Account account){
        AccountDto accountDto=AccountDto.builder()
                .fullName(account.getFullName())
                .mobileNumber(account.getMobileNumber())
                .cardNumber(account.getCardNumber())
                .balance(account.getCostumerBalance())
                .password(account.getPasswordFinCode())
                .username(account.getUser().getUsername())
                .email(account.getUser().getEmail())
                .bankName(account.getBank().getName())
                .build();
        return accountDto;
    }

    protected List<AccountDto>converterAccountList(List<Account>accountList){
        return accountList.stream()
                .map(account -> AccountDto.builder()
                        .fullName(account.getFullName())
                        .mobileNumber(account.getMobileNumber())
                        .cardNumber(account.getCardNumber())
                        .balance(account.getCostumerBalance())
                        .password(account.getPasswordFinCode())
                        .username(account.getUser().getUsername())
                        .email(account.getUser().getEmail())
                        .bankName(account.getBank().getName())
                        .build())
                .collect(Collectors.toList());
    }



}
