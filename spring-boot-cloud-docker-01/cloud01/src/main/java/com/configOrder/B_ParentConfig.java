package com.configOrder;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;

/**
 * Project: learnspringboot
 * File Created at 2022-06-17 15:57:15:57
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type B_ParentConfig.java
 * @Description
 * @date 2022/6/17 15:57
 */
@AutoConfigureBefore(A_SonConfig.class)
@Configuration
public class B_ParentConfig {
    B_ParentConfig() {
        System.out.println("配置类ParentConfig构造器被执行...");
    }
}
