package com.learnspringboot.start.listen;/*
 * Project: springboot03
 * File Created at 2021-07-02 23:55:23:55
 * @Type SecondListener.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/2 0002 23:55
 * @version
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener...init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
