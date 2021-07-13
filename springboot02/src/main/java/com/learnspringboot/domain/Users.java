package com.learnspringboot.domain;/*
 * Project: springboot03
 * File Created at 2021-07-03 23:14:23:14
 * @Type Users.java
 * @Desc
 * @author <a href="mailto: ">chenming</a>
 * @date 2021/7/3 0003 23:14
 * @version
 */

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @NotBlank：判断字符串是否为null/空串，会去掉两端空格
 * @NotEmpty:判断字符串是否为null/空串，不会去掉两端空格，意味着输入空格也能通过校验
 * @Length：字符串长度控制
 * @Min:判断数值最小值
 * @Max:判断数值最大值
 * */
public class Users implements Serializable {
    private Integer id;
    @Min(18)
    private Integer age;
    @NotBlank(message = "请输入用户名") /*非空校验*/
    @Length(min=2,max = 100,message = "您输入的姓名长度不合法")
    private String name;
    @NotBlank(message = "请输入密码")
    private String password;
    @Email
    @NotBlank
    private String email;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
