package com.neizu.paydaytrade.dto;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class UserDto {


    private String username;
    private String name;
    private String email;







}
