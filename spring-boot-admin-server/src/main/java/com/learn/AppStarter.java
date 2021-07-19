package com.learn;/*
 * Project: springboot03
 * File Created at 2021-07-19 22:01:22:01
 * @Type AppStarter.java
 * @Desc spring-boot-admin 服务端搭建
 客户端是我们要监控的工程
 * @author <a href="mailto:">chenming</a>
 * @date 2021/7/19 0019 22:01
 * @version 1.0.0
 */

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AppStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

}
