package com.learnspringboot.controller;/*
 * Project: springboot03
 * File Created at 2021-07-03 21:38:21:38
 * @Type TestExceptionController.java
 * @Desc 异常处理
 * @author <a href="mailto: ">chenming</a>
 * @date 2021/7/3 0003 21:38
 * @version 1.0.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestExceptionController {
    /**设置/templates/index.html为默认首页*/
    @RequestMapping(value = {"/","/index.html"})
    public String index() {
        String str=null;
        str.indexOf("a");
        return "index";
    }
    @RequestMapping(value = {"/show"})
    public String show() {
        int i = 1 / 0;
        return "index";
    }
}
