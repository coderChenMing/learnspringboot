package com.learnspringboot.exception.handler;/*
 * Project: springboot03
 * File Created at 2021-07-04 13:45:13:45
 * @Type GlobalExceptionHandler.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/4 0004 13:45
 * @version
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handArithmeticException(Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("error", e.toString());
        view.setViewName("arithmetic");
        return view;
    }

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView handNullPointerException(Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("error", e.toString());
        view.setViewName("nullPointer");
        return view;
    }
}
