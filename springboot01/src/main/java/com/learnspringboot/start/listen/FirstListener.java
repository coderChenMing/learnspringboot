package com.learnspringboot.start.listen;/*
 * Project: springboot03
 * File Created at 2021-07-02 23:51:23:51
 * @Type FirstListener.java
 * @Desc  监听器
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/2 0002 23:51
 * @version 1.0.0
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstListener .. init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
