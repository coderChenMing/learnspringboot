package com.learn.boot.controller;

import com.learn.boot.bean.MyClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-12 16:48:16:48
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MyClassController.java
 * @Desc
 * @date 2022/3/12 16:48
 */
@RestController
public class MyClassController {
    @GetMapping("/self")
    public MyClass myClass() {
        MyClass myClass = new MyClass();
        myClass.setName("岳阳六");
        myClass.setCount(100);
        myClass.setDate(new Date());
        return myClass;
    }
}
