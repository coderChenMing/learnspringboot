package com.learnspringboot.start.controller;/*
 * Project: springboot03
 * File Created at 2021-07-03 17:18:17:18
 * @Type TestThymeleafController.java
 * @Desc Thymeleaf测试类
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 17:18
 * @version
 */

import com.learnspringboot.start.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class TestThymeleafController {
    /**设置/templates/index.html为默认首页*/
    @RequestMapping(value={"/","/index.html"})
    public String index(Model model) {
        return "index";
    }
    /**测试字符串和日期*/
    @RequestMapping("/first/thymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("msg", "thymeleaf first test");
        model.addAttribute("today", new Date());
        return "firstTest";
    }
    /**测试if*/
    @RequestMapping("/second/test")
    public String secondTest(Model model) {
        model.addAttribute("gender", "male");
        model.addAttribute("number", 2);
        return "second";
    }
    /**测试 list*/
    @RequestMapping("/third/test")
    public String thirdTest(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(11, "李寻欢", 11));
        users.add(new User(101, "阿飞", 19));
        users.add(new User(1001, "荆无命", 110));
        model.addAttribute("users", users);
        return "third";
    }
    /**测试map*/
    @RequestMapping("/forth/test")
    public String forthTest(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("user1", new User(1, "唐三藏", 34));
        map.put("user2", new User(2, "孙悟空", 577));
        map.put("user3", new User(3, "猪八戒", 40000));
        map.put("user4", new User(4, "沙悟净", 5433));
        model.addAttribute("userMap", map);
        return "forth";
    }

    /**
     * 取域对象数据
     */
    @RequestMapping("/request/*")
    public String getContext(HttpServletRequest request, Model model) {
        request.setAttribute("request","HttpServletRequest");
        request.getSession().setAttribute("session","httpSession");
        request.getSession().getServletContext().setAttribute("app", "application");

        return "request";
    }
    /**url表达式*/
    @RequestMapping("/{page}")
    public String urlTest(@PathVariable String page,Integer id,String name) {
        System.out.println(id);
        System.out.println(name);
        return page;
    }

}
