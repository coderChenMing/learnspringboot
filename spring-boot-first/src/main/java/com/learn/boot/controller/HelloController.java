package com.learn.boot.controller;

import com.learn.boot.bean.Student;
import com.learn.boot.bean.SubmitForm;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-02 16:09:16:09
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type HelloController.java
 * @Desc
 * @date 2022/3/2 16:09
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello( String name,Integer age) {
        System.out.println(name);
        System.out.println(age);
        return name;
    }

    @PostMapping("/hello")
    public Student hello2(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

    @PostMapping("/urlEncode")
    public Map<String, Object> hello3(@RequestParam Map<String,Object> map) {
        System.out.println(map);
        return map;
    }

    @PostMapping({"/file"})
    public String fileUpload(SubmitForm submitForm, HttpServletRequest request){
        System.out.println(submitForm.getName());
        System.out.println(submitForm.getAge());
        System.out.println(submitForm.getFile().getOriginalFilename());
        System.out.println(request.getHeader("Content-Type"));
        return "success";
    }

}
