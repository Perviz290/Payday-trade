package com.neizu.paydaytrade.controller;
import com.neizu.paydaytrade.dto.UserStockDto;
import com.neizu.paydaytrade.service.UserStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paydaytrade/user/stocks")
public class UserStockController {

    private final UserStockService userStockService;


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserStockDto> getAllUserStock() {
        return userStockService.getAllUserStock();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserStockDto findUserStockByUserId(@PathVariable Integer id) {
        return userStockService.findUserStockByUserId(id);
    }









}
