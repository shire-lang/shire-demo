package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.dto.SetPaymentLimitRequest;
import com.phodal.shire.demo.dto.SetPaymentLimitResponse;
import com.phodal.shire.demo.entity.PaymentLimit;
import com.phodal.shire.demo.exception.BusinessException;
import com.phodal.shire.demo.service.PaymentLimitService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paymentLimit")
public class PaymentLimitController {

    private final PaymentLimitService paymentLimitService;

    public PaymentLimitController(PaymentLimitService paymentLimitService) {
        this.paymentLimitService = paymentLimitService;
    }

    @PostMapping("/setPaymentLimit")
    public ResponseEntity<SetPaymentLimitResponse> setPaymentLimit(@RequestBody SetPaymentLimitRequest request) {
        PaymentLimit paymentLimit = new PaymentLimit();
        BeanUtils.copyProperties(request, paymentLimit);
        paymentLimitService.setPaymentLimit(paymentLimit);
        SetPaymentLimitResponse response = new SetPaymentLimitResponse("Payment limit set successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getPaymentLimit/{accountId}")
    public ResponseEntity<PaymentLimit> getPaymentLimit(@PathVariable Long accountId) {
        try {
            PaymentLimit paymentLimit = paymentLimitService.getPaymentLimitByAccountId(accountId);
            return ResponseEntity.ok(paymentLimit);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
