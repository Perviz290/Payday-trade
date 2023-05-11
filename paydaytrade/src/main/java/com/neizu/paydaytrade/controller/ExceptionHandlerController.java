package com.neizu.paydaytrade.controller;

import com.neizu.paydaytrade.dto.response.ErrorResponse;
import com.neizu.paydaytrade.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(AccountNotFoundException.class)
    public ErrorResponse handleAccountNotFoundException(AccountNotFoundException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .date(LocalDateTime.now())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e){
        return ErrorResponse.builder()
                .message(e.getMessage())
                .date(LocalDateTime.now())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
    }

    @ExceptionHandler(UsernameAlreadyDefinedException.class)
        public ErrorResponse handleUsernameAlreadyDefinedException(UsernameAlreadyDefinedException e){
            return ErrorResponse.builder()
                    .message(e.getMessage())
                    .date(LocalDateTime.now())
                    .errorCode(HttpStatus.CONFLICT)
                    .build();
        }

        @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorResponse handleUsernameNotFoundException(UsernameNotFoundException e){
        return ErrorResponse.builder()
                .message(e.getMessage())
                .date(LocalDateTime.now())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
        }

        @ExceptionHandler(BankNotFoundException.class)
    public ErrorResponse handleBankNotFoundException(BankNotFoundException e){
            return ErrorResponse.builder()
                    .message(e.getMessage())
                    .date(LocalDateTime.now())
                    .errorCode(HttpStatus.NOT_FOUND)
                    .build();
        }









    }



