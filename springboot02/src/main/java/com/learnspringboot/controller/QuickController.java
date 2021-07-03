package com.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderChenMing
 * @create 2021-03-25-16:40
 * @description 测试
 */
@RestController
public class QuickController {
    @Value("${name}")
    private String name;
    @Value("${student1.addr}")
    private String addr;
    @RequestMapping("quick")
    public String quick() {

        return "HelloSpringBoot change";
    }
    @RequestMapping("yml")
    public String getYml() {
        System.out.println(name);
        System.out.println(addr);
        return name+addr;
    }
}
