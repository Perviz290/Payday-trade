package com.neizu.paydaytrade.dto.request;
import com.neizu.paydaytrade.entity.Bank;
import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class CreateAccountRequest {

    private String fullName;
    private String mobileNumber;
    private String passwordFinCode;
    private Integer userId;
    private Integer bankId;






















}
