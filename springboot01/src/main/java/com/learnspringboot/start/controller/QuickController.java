package com.learnspringboot.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author coderChenMing
 * @create 2021-03-25-15:47
 * @description controller测试
 */
@Controller
public class QuickController {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick() {
        return " SpringBoot";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }
}
