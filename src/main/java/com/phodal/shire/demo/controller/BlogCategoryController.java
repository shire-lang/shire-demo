package com.phodal.shire.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "BlogCategoryController", description = "博客分类控制器")
@RestController
public class BlogCategoryController {

    @ApiOperation(value = "关闭银行账户", notes = "关闭指定银行账户")
    @GetMapping("/close-bank-account")
    public String closeBankAccount() {
        // Close a bank account
        return "Bank account closed";
    }
}