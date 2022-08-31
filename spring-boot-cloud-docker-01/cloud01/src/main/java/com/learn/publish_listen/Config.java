package com.learn.publish_listen;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:06:15:06
 * {@link}
 * 解决方式二:使用@DependsOn
 * Spring提供了一个@DependsOn注解，能够解决这类问题。这个场景的核心思想是：猫（监听者）必须确保在主人（事件发送者）放鱼（发送事件动作）
 * 之前完成实例化且注册监听，这样才不会错过每一条鱼。所以我们可以这么做（依旧基于原Config.java文件做出修改）：
 * 完美。这种处理方式是被推荐的方式，它能显示的控制Bean的依赖关系，而不受到其它影响，是值得信赖的使用方式。
 * 说明：在“编程界”有个设计原则：显示的指出往往比隐式的更好，更稳定和更具表达力
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Config.java
 * @Description
 * @date 2022/6/17 15:06
 */
@Configuration(proxyBeanMethods = false)
public class Config {
    // @DependsOn // 若里面不写值，该注解无效。但若写了值，请确保里面的Bean都有，否则报错
    @DependsOn({"cc", "tom"})
    @Bean
    public MasterBean master() {
        return new MasterBean();
    }

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

    /*测试类*/
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config.class);
        Master.getMaster().giveFish();
        Master.getMaster().giveFish();
        //从debug日志中很明显的看到这些Bean的初始化顺序为：config -> master -> tom -> cc，所以当master初始化完毕后放出鱼时，两只猫都没有监听到，所以错失了首次放的鱼，这也就是错失某些事件的例子，在生产上很多时候是不能容忍的，需要解决。
        // TODO
    }
}
