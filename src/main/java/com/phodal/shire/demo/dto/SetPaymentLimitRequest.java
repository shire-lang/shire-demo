package com.phodal.shire.demo.dto;

public class SetPaymentLimitRequest {
    private Long accountId;
    private Double newLimit;

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setNewLimit(Double newLimit) {
        this.newLimit = newLimit;
    }

    public Double getNewLimit() {
        return newLimit;
    }
}