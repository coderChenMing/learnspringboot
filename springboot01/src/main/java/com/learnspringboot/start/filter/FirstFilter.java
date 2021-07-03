package com.learnspringboot.start.filter;/*
 * Project: springboot03
 * File Created at 2021-07-02 23:37:23:37
 * @Type FirstFilter.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/2 0002 23:37
 * @version
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/first")
public class FirstFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("in FirstFilter");
        chain.doFilter(request, response);
        System.out.println("out FirstFilter");

    }

    @Override
    public void destroy() {

    }
}
