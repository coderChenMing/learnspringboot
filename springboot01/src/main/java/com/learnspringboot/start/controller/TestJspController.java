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
public class TestJspController {
    @RequestMapping("/jsp")
    public String showUser(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "刘备", 1));
        users.add(new User(10, "关羽", 10));
        users.add(new User(100, "张飞", 10));
        // 需要一个model对象
        model.addAttribute("list", users);
        //跳转视图
        return "userList";


    }
}
