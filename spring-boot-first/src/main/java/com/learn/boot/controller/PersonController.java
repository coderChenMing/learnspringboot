package com.learn.boot.controller;

import com.learn.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-07 23:38:23:38
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type PersonController.java
 * @Desc
 * @date 2022/3/7 23:38
 */
@RestController
public class PersonController {
    @Autowired
    private Person person;
    @GetMapping("/person")
    public Person person() {
        System.out.println(person.getUsername());
        return person;
    }

    @GetMapping("/xml")
    public Person xml() {
        Person person = new Person();
        person.setAge(20);
        person.setUsername("李四");
        person.setBirth(new Date());
        return person;
    }
}
