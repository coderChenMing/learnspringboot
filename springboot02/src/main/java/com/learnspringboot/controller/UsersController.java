package com.learnspringboot.controller;/*
 * Project: springboot03
 * File Created at 2021-07-03 23:32:23:32
 * @Type UsersController.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 23:32
 * @version
 */

import com.learnspringboot.domain.Users;
import com.learnspringboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    /**映射静态资源*/
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {

        return page;
    }
    /**添加用户*/
    @RequestMapping("/addUser")
    public String addUser(Users users) {
        usersService.addUser(users);
        return "success";
    }
    /**查询用户列表*/
    @RequestMapping("/findUsersAll")
    public String findAll(Model model) {
        List<Users> users = usersService.findUserAll();
        model.addAttribute("users", users);
        return "allUsers";
    }
    /**查询单个用户*/
    @RequestMapping("/findUsersById")
    public String findUsersById(Integer id, Model model) {
        Users users = usersService.findUsersById(id);
        model.addAttribute("user", users);
        return "updateUser";
    }
    /**更新用户*/
    @RequestMapping("/updateUser")
    public String updateUser(Users users, Model model) {
        usersService.updateUser(users);
        return "success";
    }
    /**删除用户*/
    @RequestMapping("/deleteUsersById")
    public String deleteUsersById(Integer id) {
        usersService.deleteUsersById(id);
        return "redirect:/users/findUsersAll";
    }
}
