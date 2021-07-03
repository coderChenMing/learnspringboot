package com.learnspringboot.start;/*
 * Project: springboot03
 * File Created at 2021-07-03 21:54:21:54
 * @Type MvcConfig.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/3 0003 21:54
 * @version
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*配置只能访问templates目录下静态资源/
      /*  registry.addResourceHandler("/**").addResourceLocations("/**", "classpath:/templates");*/
        super.addResourceHandlers(registry);
    }
}
