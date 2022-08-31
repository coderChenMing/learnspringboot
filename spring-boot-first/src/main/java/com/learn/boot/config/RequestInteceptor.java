package com.learn.boot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project: spring-boot-first
 * File Created at 2022-03-12 22:56:22:56
 * {@link}
 * 定义拦截器:控制访问权限和静态资源
 * 1.配置拦截请求和放行请求
 * 2.将拦截器注入spring容器
 *
 * 本拦截器拦截规则:拦截未登录用户
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type RequestInteceptor.java
 * @Desc
 * @date 2022/3/12 22:56
 */
@Slf4j
public class RequestInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*log.info("preHandle execute....");
        log.info("当前拦截请求:"+request.getRequestURI());
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;//放行
        }
        request.setAttribute("msg","请先登录");
        // 重定向到未登录页
        request.getRequestDispatcher("/").forward(request,response);*/
        return true;//拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle execute....{}",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion execute....",ex);
    }
}
