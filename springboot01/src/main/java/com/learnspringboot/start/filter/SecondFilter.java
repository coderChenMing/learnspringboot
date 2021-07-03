package com.learnspringboot.start.filter;/*
 * Project: springboot03
 * File Created at 2021-07-02 23:46:23:46
 * @Type SecondFilter.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/2 0002 23:46
 * @version
 */


import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("in SecondFilter");
        chain.doFilter(request, response);
        System.out.println("out SecondFilter");
    }

    @Override
    public void destroy() {

    }
}
