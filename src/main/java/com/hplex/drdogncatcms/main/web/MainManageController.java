package com.hplex.drdogncatcms.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainManageController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

}
