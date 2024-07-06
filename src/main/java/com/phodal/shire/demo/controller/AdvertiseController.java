package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.base.CommonResult;
import com.phodal.shire.demo.entity.Advertise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/advertise")
public class AdvertiseController {

    /**
     * Get a list of advertisements.
     *
     * @return CommonResult object containing a list of Advertise objects
     */
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
