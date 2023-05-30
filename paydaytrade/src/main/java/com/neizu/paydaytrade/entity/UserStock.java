package com.neizu.paydaytrade.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserStock {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String stockName;

    private BigDecimal stockPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public UserStock(String stockName, BigDecimal stockPrice, User user) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.user = user;
    }
}
