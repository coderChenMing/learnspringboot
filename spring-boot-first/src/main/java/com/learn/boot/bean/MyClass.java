package com.learn.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-11 22:23:22:23
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Class.java
 * @Desc
 * @date 2022/3/11 22:23
 */
@Data
public class MyClass {
    private String name;
    private Integer count;
    private Date date;
    private Student student;
}
