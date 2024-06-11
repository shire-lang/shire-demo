package com.phodal.shire.demo.repository;

import com.phodal.shire.demo.entity.PaymentLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentLimitRepository extends JpaRepository<PaymentLimit, Long> {

}