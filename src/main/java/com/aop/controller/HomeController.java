package com.aop.controller;

import com.aop.service.HomeService;
import com.aop.util.DataViewBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by alexanderli on 2/5/15.
 */
@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/home")
    public String toHome() {
        homeService.initData();
        return "home";
    }

    @RequestMapping(value = "/send/data")
    public Boolean sendData(@RequestParam String phoneNumber,
                           @RequestParam String code,
                           @RequestParam Integer count) {
        return homeService.updateServerData(phoneNumber, code, count);
    }

    @RequestMapping(value = "/check/code")
    public String sendData(@RequestParam String code) {
        return homeService.checkProduct(code);
    }

    @RequestMapping(value = "get/data")
    @ResponseBody
    public List<DataViewBean> getData() {
        return homeService.getDataViewBeans();
    }

}
