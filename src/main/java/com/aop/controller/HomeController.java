package com.aop.controller;

import com.aop.service.HomeService;
import com.aop.util.DataViewBean;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/home/send/data", method = RequestMethod.POST)
    @ResponseBody
    public String sendData(@RequestParam String phoneNumber,
                           @RequestParam String code,
                           @RequestParam Integer count) throws JSONException {
        JSONObject object = new JSONObject();
        object.put("result", homeService.updateServerData(phoneNumber, code, count));
        return object.toString();
    }

    @RequestMapping(value = "/home/check/code", method = RequestMethod.POST)
    @ResponseBody
    public String sendData(@RequestParam String code) throws JSONException {
        return homeService.checkProduct(code);
    }

    @RequestMapping(value = "/home/get/data")
    @ResponseBody
    public List<DataViewBean> getData() {
        return homeService.getDataViewBeans();
    }

    @RequestMapping(value = "/home/create/product", method = RequestMethod.GET)
    @ResponseBody
    public List<DataViewBean> getData(@RequestParam String productCode,
                                      @RequestParam String productName,
                                      @RequestParam String productAmount) {
        homeService.createProduct(productCode, productName, productAmount);
        return homeService.getDataViewBeans();
    }

}
