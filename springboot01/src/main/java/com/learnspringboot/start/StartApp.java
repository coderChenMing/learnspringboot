package com.learnspringboot.start;

import com.learnspringboot.start.filter.SecondFilter;
import com.learnspringboot.start.listen.SecondListener;
import com.learnspringboot.start.servlet.MySecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

@SpringBootApplication
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> getServletBean() {
        ServletRegistrationBean<HttpServlet> bean = new ServletRegistrationBean<>(new MySecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
    @Bean
    public FilterRegistrationBean<Filter> getFilterBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new SecondFilter());
        bean.addUrlPatterns("/second");
        return bean;
    }
    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> getListenerBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>(new SecondListener());
        return bean;
    }
}
