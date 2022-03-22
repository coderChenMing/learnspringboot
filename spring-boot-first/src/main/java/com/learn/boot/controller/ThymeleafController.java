package com.learn.boot.controller;

import com.learn.boot.bean.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-12 19:48:19:48
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ThymeleafController.java
 * @Desc
 * @date 2022/3/12 19:48
 */
@Controller
@Slf4j
public class ThymeleafController {

    @GetMapping("first")
    public String first(Model model) {
        model.addAttribute("msg", "first thymeleaf");
        model.addAttribute("link", "https://www.baidu.com");
        return "success";
    }
    @GetMapping("/")
    public String index() {
        return "login";
    }
    @PostMapping("/login")
    public String login(LoginUser user, HttpSession session,Model model) {
        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("user",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg", "账号密码错误！");
        }
        return "login";
    }
    @GetMapping("/main.html")
    public String main() {
        return "main";
    }

    @GetMapping("/upload.html")
    public String upload() {
        return "upload";
    }
    @PostMapping("/upload")
    public String uploadFile(
        @RequestParam("email") String email,
        @RequestParam("username") String username,
        @RequestPart("headerImg") MultipartFile headerImg,
        @RequestPart("photos") MultipartFile[] photos

    ) {
        log.info("email:{},username:{},headerImg:{},photos:{}",email,username,headerImg,photos);
        if (headerImg != null) {
            try {
                headerImg.transferTo(new File("d:\\test"+headerImg.getOriginalFilename()));
            } catch (IOException e) {
                log.error("文件上传失败",e);
            }
        }
        if (photos != null) {
            for (MultipartFile photo : photos) {
                try {
                    photo.transferTo(new File("d:\\test"+photo.getOriginalFilename()));
                } catch (IOException e) {
                    log.error("文件上传失败",e);
                }
            }
        }
        return "main";
    }
}
