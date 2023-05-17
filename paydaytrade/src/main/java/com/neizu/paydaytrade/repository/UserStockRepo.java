package com.neizu.paydaytrade.repository;


import com.neizu.paydaytrade.entity.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserStockRepo extends JpaRepository<UserStock,Integer>, JpaSpecificationExecutor<UserStock> {


    UserStock findUserStockByUserId(Integer id);


}
