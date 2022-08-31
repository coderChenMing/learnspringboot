package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Project: spring-boot-cloud-docker-01
 * File Created at 2022-03-24 17:52:17:52
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type HelloController.java
 * @Desc
 * @date 2022/3/24 17:52
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "hello world";
    }

    @RequestMapping("/index")
    public String index() {

        return "index";
    }
}
