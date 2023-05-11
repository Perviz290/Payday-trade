package com.neizu.paydaytrade.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String message;
    private LocalDateTime date;
    private HttpStatus errorCode;

}
