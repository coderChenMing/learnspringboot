package com.learnspringboot.config;/*
 * Project: springboot03
 * File Created at 2021-07-04 13:54:13:54
 * @Type GlobalExceptionHandler.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 13:54
 * @version
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class GlobalExceptionHandlerConfig {

    /**
     * 返回SimpleMappingExceptionResolver
     */
    @Bean
    public SimpleMappingExceptionResolver getExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        // key:异常类型全名，vaLue:视图名称
        properties.put("java.lang.ArithmeticException", "arithmetic");
        properties.put("java.lang.NullPointerException", "nullPointer");
        // 将事先定义好的异常视图添加进去
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
