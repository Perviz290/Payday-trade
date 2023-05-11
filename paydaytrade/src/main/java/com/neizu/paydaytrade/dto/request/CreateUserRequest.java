package com.neizu.paydaytrade.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {

    private String username;
    private String name;
    private String email;






}
