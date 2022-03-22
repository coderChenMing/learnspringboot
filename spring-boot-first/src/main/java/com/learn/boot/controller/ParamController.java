package com.learn.boot.controller;

import com.learn.boot.bean.MyClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-11 22:29:22:29
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ParamController.java
 * @Desc
 * @date 2022/3/11 22:29
 */
@Controller
public class ParamController {
    @GetMapping("/goto")
    public String gotoPage() {
        return "forward:success";
    }

    @GetMapping("/test")
    @ResponseBody
    public Map success() {
        Map<String, Object> map = new HashMap<>();

        return map;
    }

    @PostMapping("/saveClass")
    @ResponseBody
    public MyClass saveUser(MyClass myClass) {

        return myClass;
    }

    @GetMapping("/user")
    @ResponseBody
    public String get() {

        return "get-user";
    }

    @PostMapping("/user")
    @ResponseBody
    public String post() {

        return "post-user";
    }

    @PutMapping("/user")
    @ResponseBody
    public String put() {

        return "put-user";
    }

    @DeleteMapping("/user")
    @ResponseBody
    public String delete() {

        return "delete-user";
    }


}
