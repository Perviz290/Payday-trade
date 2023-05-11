package com.neizu.paydaytrade.repository;

import com.neizu.paydaytrade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User ,Integer> {


    Optional<User> findUserByUsername(String username);






}