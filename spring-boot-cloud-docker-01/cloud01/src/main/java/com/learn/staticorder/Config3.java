package com.learn.staticorder;

import com.learn.bean.Family;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:06:15:06
 * {@link}
 *  @Configuration配置类最优先被初始化，才会继续初始化其里面的@Bean
 * 若有多个 @Configuration配置类，顺序由你构造AnnotationConfigApplicationContext时传入的顺序为准（若是被scan扫描进去的，则无序）
 * @Bean方法上加static成为静态方法，并不能提升此Bean的优先级
 * 主要是因为@Bean的解析，必须是发生在@Configuration配置类被实例化后，因此它并不能提升优先级
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Config.java
 * @Description
 * @date 2022/6/17 15:06
 */
@Configuration(proxyBeanMethods = false)
public class Config3 {
    public Config3() {
        System.out.println("配置类Config构造器被执行...");
    }


    @Bean
    public Family family() {
        System.out.println("@Bean -> family执行...");
        return new Family();
    }

    // 注意这个是静态方法 @Bean方法上加static成为静态方法，并不能提升此Bean的优先级
    // 主要是因为@Bean的解析，必须是发生在@Configuration配置类被实例化后，因此它并不能提升优先级
    @Bean
    public static Family staticFamily() {
        System.out.println("@Bean -> staticFamily执行...");
        return new Family();
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config3.class, PersonConfig.class);
    }
}
