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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestThymeleafController {
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
    /**
     * 异常处理
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handArithmeticException(Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("error", e.toString());
        view.setViewName("arithmetic");
        return view;
    }
}
