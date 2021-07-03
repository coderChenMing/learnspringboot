package com.learnspringboot.controller;/*
 * Project: springboot03
 * File Created at 2021-07-03 21:38:21:38
 * @Type TestThymeleafController.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 21:38
 * @version
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestThymeleafController {
    @RequestMapping(value = {"/","/index.html"})
    public String index() {
        return "index";
    }
}
