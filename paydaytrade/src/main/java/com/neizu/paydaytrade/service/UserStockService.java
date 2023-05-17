package com.neizu.paydaytrade.service;


import com.neizu.paydaytrade.controller.UserStockController;
import com.neizu.paydaytrade.dto.UserStockDto;
import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.exception.UserNotFoundException;
import com.neizu.paydaytrade.repository.UserRepo;
import com.neizu.paydaytrade.repository.UserStockRepo;
import com.neizu.paydaytrade.util.UserStockConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserStockService {

    private final UserStockRepo userStockRepo;
   // private final UserRepo userRepo;
    private final UserService userService;
    private final UserStockConverter userStockConverter;


    public List<UserStockDto> getAllUserStock() {
        return userStockRepo.findAll()
                .stream()
                .map(userStockConverter :: converter )
                .collect(Collectors.toList());
    }


    public UserStockDto findUserStockByUserId(Integer id) {
       User user=userService.findById(id);
        return userStockConverter.converter(userStockRepo.findUserStockByUserId(id));
    }




}
