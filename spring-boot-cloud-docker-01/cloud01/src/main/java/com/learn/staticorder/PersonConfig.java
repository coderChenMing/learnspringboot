package com.learn.staticorder;

import com.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:31:15:31
 * {@link}
 * @Configuration（外层）配置类的初始化顺序依旧是按照AnnotationConfigApplicationContext的定义顺序来的
 * 对于内部类的@Configuration的初始化（不管是静态还是非静态），也依旧是外部的@Configuration完成后才行
 * 内部类里的@Bean的优先级均高于外层定义的@Bean，同时可以看到static静态内部类能够提升优先级，它比非静态内部类的优先级还高
 * 内部类有限原则它只作用于本@Configuration类，也就是说仅在本主类内提升优先级。
 * 另外若出现多个内部类，按照定义顺序执行（static永远高于非static哦）
 * 内部类的访问权限无所谓，private都行。
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type PersonConfig.java
 * @Description
 * @date 2022/6/17 15:31
 */
@Configuration(proxyBeanMethods = false)
public class PersonConfig {
    public PersonConfig() {
        System.out.println("配置类PersonConfig构造器执行...");
    }

    @Bean
    public Person son() {
        System.out.println("@Bean -> son执行...");
        return new Person("YourBatman-son", 18);
    }

    @Bean
    public Person father() {
        System.out.println("@Bean -> father执行...");
        return new Person("YourBatman", 48);
    }

    // 以下是改进方式使用static
    // 非静态内部类
    @Configuration(proxyBeanMethods = false)
    private class InnerClass {

        public InnerClass() {
            System.out.println("内部配置类InnerClass构造器被执行...");
        }
        @Bean
        public Person innerPerson() {
            System.out.println("@Bean -> innerPerson执行...");
            return new Person();
        }
    }

    // static静态内部类
    @Configuration(proxyBeanMethods = false)
    private static class StaticInnerClass {

        public StaticInnerClass() {
            System.out.println("静态内部配置类StaticInnerClass构造器被执行...");
        }
        @Bean
        public Person staticInnerPerson() {
            System.out.println("@Bean -> staticInnerPerson执行...");
            return new Person();
        }
    }
}
