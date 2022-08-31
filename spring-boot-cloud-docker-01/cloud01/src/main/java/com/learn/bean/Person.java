package com.learn.bean;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:31:15:31
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Person.java
 * @Description
 * @date 2022/6/17 15:31
 */
public class Person {
    private String name ;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
