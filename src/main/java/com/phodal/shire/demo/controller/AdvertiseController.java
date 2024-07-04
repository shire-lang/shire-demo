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
     * @return CommonResult<List < Advertise>> A common result object containing a list of advertisements.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Advertise>> list() {
        List<Advertise> companyAddressList = new ArrayList<>();
        return CommonResult.success(companyAddressList);
    }
}
