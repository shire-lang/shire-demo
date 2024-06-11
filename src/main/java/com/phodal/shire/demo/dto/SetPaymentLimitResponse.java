package com.phodal.shire.demo.dto;

public class SetPaymentLimitResponse {
    private String message;

    public SetPaymentLimitResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}