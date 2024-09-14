package com.phodal.shire.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogCategoryController {

    @GetMapping("/close-bank-account")
    public String closeBankAccount() {
        // Close a bank account
        return "Bank account closed";
    }
}