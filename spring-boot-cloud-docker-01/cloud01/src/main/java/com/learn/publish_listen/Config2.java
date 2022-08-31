/*
package com.learn.publish_listen;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:06:15:06
 * {@link}
 * 解决方式1
 * 问题解决：猫兄吃到了所有的鱼，从debug日志中Bean的实例化顺序能够解释为何它能迟到所有的鱼。但是，但是，但是此解决方案并不推荐，原因如下：
 *
 * 该方案强依赖于这个规则：同一配置类下，Bean的实例化顺序是按照从上至下的顺序实例化的。一旦你的相关配置处在不同配置类内，此顺序是确定不了的
 * 这种顺序是由程序员来人工确保的，而非通过结构来固化，因此容错性极低。所以生产上极不推荐这么做
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Config.java
 * @Description
 * @date 2022/6/17 15:06
 *//*

@Configuration(proxyBeanMethods = false)
public class Config2 {


    @Bean
    public Cat tom() {
        Cat tom = new Cat("Tom");
        Master.getMaster().addObserver(tom);
        return tom;
    }

    @Bean
    public Cat cc() {
        Cat cc = new Cat("Cc");
        Master.getMaster().addObserver(cc);
        return cc;
    }

    @Bean
    public MasterBean master() {
        return new MasterBean();
    }
    */
/*测试类*//*

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config2.class);
        Master.getMaster().giveFish();
        Master.getMaster().giveFish();
    }
}
*/
