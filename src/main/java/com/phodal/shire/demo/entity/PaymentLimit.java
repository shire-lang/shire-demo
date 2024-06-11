package com.phodal.shire.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tw_payment_limit")
@Data
public class PaymentLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "limit_amount")
    private Double limitAmount;
}