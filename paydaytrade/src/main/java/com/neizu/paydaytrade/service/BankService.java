package com.neizu.paydaytrade.service;


import com.neizu.paydaytrade.entity.Bank;
import com.neizu.paydaytrade.exception.BankNotFoundException;
import com.neizu.paydaytrade.repository.BankRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepo bankRepo;


    protected Bank findById(Integer id) {
        Optional<Bank> findedBank = bankRepo.findById(id);
        if (findedBank.isEmpty()) {
            throw new BankNotFoundException(id + "-This BankId NotFound");
        } else {
            return findedBank.get();
        }
    }









}
