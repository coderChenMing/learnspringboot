package com.learn.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-02 16:51:16:51
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type User.java
 * @Desc
 * @date 2022/3/2 16:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Pet pet;
}
