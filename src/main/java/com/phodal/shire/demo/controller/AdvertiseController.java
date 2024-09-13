package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.base.CommonResult;
import com.phodal.shire.demo.entity.Advertise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "AdvertiseController", description = "广告管理")
@Controller
@RequestMapping("/advertise")
public class AdvertiseController {

    @ApiOperation(value = "获取广告列表", notes = "获取所有广告的列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Advertise>> getList() {
        List<Advertise> companyAddressList = createCompanyAddressList();
        return CommonResult.success(companyAddressList);
    }

    private List<Advertise> createCompanyAddressList() {
        return new ArrayList<>();
    }
}