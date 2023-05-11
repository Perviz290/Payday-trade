package com.neizu.paydaytrade.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.math.BigInteger;


@Data
@Builder
public class AccountDto {

    private String fullName;
    private String mobileNumber;
    private String cardNumber;
    private BigDecimal balance;
    private String password;
    private String username;
    private String email;
    private String bankName;


}





