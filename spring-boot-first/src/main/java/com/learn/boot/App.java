package com.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-02 16:09:16:09
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type App.java
 * @Desc
 * @date 2022/3/2 16:09
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
       SpringApplication.run(App.class, args);
       /* Stream.of(container.getBeanDefinitionNames()).forEach(System.out::println);
        MyConfig myConfig = container.getBean(MyConfig.class);
        System.out.println(myConfig);
        System.out.println(container.containsBean("user01"));*/

    }
}
