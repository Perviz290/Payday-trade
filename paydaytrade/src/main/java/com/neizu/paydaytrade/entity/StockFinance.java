package com.neizu.paydaytrade.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StockFinance implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    private String name;

    private BigDecimal price;

    private BigDecimal changed;






}
