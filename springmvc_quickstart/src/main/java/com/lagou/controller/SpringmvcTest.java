package com.lagou.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringmvcTest {

    @RequestMapping("/testException")
    public String testException() {
        System.out.println("test");
        int i = 1 / 0;
        return "success";
    }
}
