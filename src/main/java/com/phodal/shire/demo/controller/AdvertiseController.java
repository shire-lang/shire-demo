package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.base.CommonResult;
import com.phodal.shire.demo.entity.Advertise;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/advertise")
public class AdvertiseController {

    @ResponseBody
    public CommonResult<List<Advertise>> getList() {
        List<Advertise> companyAddressList = createCompanyAddressList();
        return CommonResult.success(companyAddressList);
    }

    private List<Advertise> createCompanyAddressList() {
        return new ArrayList<>();
    }
}