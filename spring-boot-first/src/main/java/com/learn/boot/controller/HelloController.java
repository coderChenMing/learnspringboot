package com.learn.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-02 16:09:16:09
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type HelloController.java
 * @Desc
 * @date 2022/3/2 16:09
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {

        return "hello";
    }
}
