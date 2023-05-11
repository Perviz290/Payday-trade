package com.neizu.paydaytrade.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserAccountDto {


    private String username;
    private String name;
    private String email;
    private List<AccountDto>accountList;








}
