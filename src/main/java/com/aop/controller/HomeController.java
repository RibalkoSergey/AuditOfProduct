package com.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by alexanderli on 2/5/15.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String toHome() {
        return "home";
    }

    @RequestMapping(value = "/send/data")
    public String sendData(@RequestParam Long aLong) {
        System.out.print(aLong);
        return "home";
    }

}
