package com.learnspringboot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author coderChenMing
 * @create 2021-03-25-15:34
 * @description it's a starter
 */
@SpringBootApplication
@ServletComponentScan
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }
}
