package com.learn.configOrder;

import org.springframework.context.annotation.Configuration;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:58:15:58
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type C_DemoConfig.java
 * @Description
 * @date 2022/6/17 15:58
 */
@Configuration
public class C_DemoConfig {
    public C_DemoConfig(){
        System.out.println("我是被自动扫描的配置，初始化啦....");
    }
}
