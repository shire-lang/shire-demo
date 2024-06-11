package com.phodal.shire.demo.service;

import com.phodal.shire.demo.entity.PaymentLimit;
import com.phodal.shire.demo.exception.BusinessException;
import com.phodal.shire.demo.repository.PaymentLimitRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentLimitService {
    PaymentLimitRepository paymentLimitRepository;

    public PaymentLimitService(PaymentLimitRepository paymentLimitRepository) {
        this.paymentLimitRepository = paymentLimitRepository;
    }

    public PaymentLimit setPaymentLimit(PaymentLimit paymentLimit) {
        // Add business logic here
        return paymentLimitRepository.save(paymentLimit);
    }

    public PaymentLimit getPaymentLimitByAccountId(Long accountId) throws BusinessException {
        // Add business logic here
        return paymentLimitRepository.findById(accountId)
                .orElseThrow(() -> new BusinessException("Payment limit not found"));
    }
}