package com.neizu.paydaytrade.controller;


import com.neizu.paydaytrade.dto.UserAccountDto;
import com.neizu.paydaytrade.dto.request.CreateUserRequest;
import com.neizu.paydaytrade.dto.request.UpdateUserDto;
import com.neizu.paydaytrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserAccountDto> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserAccountDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public UserAccountDto findUserByEmail(@RequestParam String username){
        return userService.findUserByEmail(username);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserAccountDto updateUser(@PathVariable(value = "id") Integer id,
                           @RequestBody UpdateUserDto updateDto) {
        return userService.updateUser(id, updateDto);
    }



















}
