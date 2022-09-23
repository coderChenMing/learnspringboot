package com.learn.boot.controller;

import com.learn.boot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: spring-boot-first
 * File Created at 2022-09-01 17:39:17:39
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ModelController.java
 * @Description
 * @date 2022/9/1 17:39
 */
@RestController
public class ModelController {

    @GetMapping("/model")
    @ModelAttribute
    public Student testModer() {
        Student student = new Student();
        student.setAge(12);
        student.setName("张三");
        return student;
    }
}
