package com.learnspringboot.start.controller;/*
 * Project: springboot03
 * File Created at 2021-07-03 15:54:15:54
 * @Type TestJspController.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 15:54
 * @version
 */

import com.learnspringboot.start.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestFtlController {
    @RequestMapping("/ftl")
    public String showUser(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(11, "张三", 11));
        users.add(new User(101, "李四", 19));
        users.add(new User(1001, "王五", 110));
        // 需要一个model对象
        model.addAttribute("users", users);
        //跳转视图
        return "user";


    }
}
