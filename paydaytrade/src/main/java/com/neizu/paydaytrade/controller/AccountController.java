package com.neizu.paydaytrade.controller;

import com.neizu.paydaytrade.dto.AccountDto;
import com.neizu.paydaytrade.dto.request.CreateAccountRequest;
import com.neizu.paydaytrade.dto.request.DepositAccountDto;
import com.neizu.paydaytrade.dto.request.UpdateAccountDto;
import com.neizu.paydaytrade.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBank(@RequestBody CreateAccountRequest createAccountRequest) {
        accountService.createAccount(createAccountRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccount() {
        return accountService.getAllAccount();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getAccountById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AccountDto updateAccount(@PathVariable(value = "id") Integer id,
                                      @RequestBody UpdateAccountDto updateDto) {
        return accountService.updateAccount(id, updateDto);
    }

    @PatchMapping("/deposit/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AccountDto loadMoneyAccount(@PathVariable(value = "id") Integer id,
                                    @RequestBody DepositAccountDto depositDto) {
        return accountService.loadMoneyAccount(id, depositDto);
    }






























}


















