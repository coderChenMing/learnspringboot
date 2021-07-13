package com.learnspringboot.config.exception;/*
 * Project: springboot03
 * File Created at 2021-07-04 14:18:14:18
 * @Type DefineGlobalExceptionHandler.java
 * @Desc   自定义异常处理最优
 * @author <a href="mailto: ">chenming</a>
 * @date 2021/7/4 0004 14:18
 * @version 1.0.0
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class DefineGlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        ModelAndView view = new ModelAndView();
        // 判断不同异常对象，进行跳转
        if (ex instanceof ArithmeticException) {
            view.setViewName("arithmetic");
        } else if (ex instanceof NullPointerException) {
            view.setViewName("nullPointer");
        }
        view.addObject("error", ex.toString());
        return view;
    }
}
