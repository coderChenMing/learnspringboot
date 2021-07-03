package com.learnspringboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderChenMing
 * @create 2021-03-25-16:40
 * @description 快速测试controller
 */
@RestController
@ConfigurationProperties(prefix ="student1")
public class QuickController2 {
    private String name;
    private String addr;
    private int age;

    @RequestMapping("quick2")
    public String quick() {

        return "HelloSpringBoot change";
    }

    @RequestMapping("yml2")
    public String getYml() {
        System.out.println(name);
        System.out.println(addr);
        System.out.println(age);
        return name + addr+age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
