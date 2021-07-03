package com.learnspringboot.domain;/*
 * Project: springboot03
 * File Created at 2021-07-03 23:14:23:14
 * @Type Users.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 23:14
 * @version
 */

public class Users {
    private Integer id;
    private Integer age;
    private String name;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
