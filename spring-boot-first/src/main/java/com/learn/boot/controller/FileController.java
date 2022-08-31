package com.learn.boot.controller;

import com.learn.boot.bean.FormSubmit;
import com.learn.boot.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Project: spring-boot-first
 * File Created at 2022-08-31 15:53:15:53
 * {@link}
 * @RequestBody body 与@RequestParam MultipartFile file 不能同时使用证明及解决办法
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type FileController.java
 * @Description
 * @date 2022/8/31 15:53
 */

@Controller
public class FileController {
    
    @PostMapping({"/submit","check"})
    public String checkFile(FormSubmit submit){
        System.out.println(submit.getFileList());
        System.out.println(submit.getStuList());
        return "success";
    }

    /*这种参数形式永远无法接收*/
    @PostMapping({"/param"})
    public String testParamAndBody(@RequestBody Student student, @RequestParam("file") MultipartFile file){
        System.out.println(student);
        System.out.println(file.getOriginalFilename());
        return "success";
    }

    @PostMapping({"/param2"})
    public String testParamAndBody2(@RequestParam String name,@RequestParam Integer age ,@RequestParam("file") MultipartFile file){
        System.out.println(name);
        System.out.println(age);
        System.out.println(file.getOriginalFilename());
        return "success";
    }

    /*转json接收*/
    @PostMapping({"/param3"})
    public String testParamAndBody3(@RequestParam String json ,@RequestParam("file") MultipartFile file){
        System.out.println(json);
        System.out.println(file.getOriginalFilename());
        return "success";
    }

    @PostMapping({"/param4"})
    public String testParamAndBody4(@RequestBody Student student, @RequestParam String address){
        System.out.println(student);
        System.out.println(address);
        return "success";
    }

}
